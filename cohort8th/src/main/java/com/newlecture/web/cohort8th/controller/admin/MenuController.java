package com.newlecture.web.cohort8th.controller.admin;

import com.newlecture.web.cohort8th.dto.MenuRegDto;
import com.newlecture.web.cohort8th.entity.*;
import com.newlecture.web.cohort8th.model.MenuDetailModel;
import com.newlecture.web.cohort8th.service.CategoryService;
import com.newlecture.web.cohort8th.service.MenuService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller("adminMenuController")
@RequestMapping("admin/menu")
public class MenuController {

//    @Autowired
//    private ServletContext context;

    @Autowired
    private MenuService service;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("list")
    public String list(Model model,
                       @RequestParam(name = "c", required = false)
                       Integer categoryId,

                       @RequestParam(name = "q", required = false)
                           String query,

                       @RequestParam(name = "order", required = false)
                           String order) {

        List<Category> categories = categoryService.getList();
        List<MenuView> menus = service.getList(categoryId, query, order);

        model.addAttribute("categories", categories);
        model.addAttribute("menus", menus);

        return "admin/menu/list";
    }

    @GetMapping("detail")
    public String detail(Long id ,Model model) {
        MenuDetailModel menuModel = service.getDetailById(id);
        System.out.println(menuModel);

//        model.addAttribute("menuModel", menuModel);
        model.addAttribute("menu", menuModel.getMenu());
        model.addAttribute("imgs", menuModel.getImages());
        model.addAttribute("rcmds", menuModel.getRcmdMenus());

        return "admin/menu/detail";
    }

    @GetMapping("reg")
    public String reg(Model model) {

        List<Category> categories = categoryService.getList();
        model.addAttribute("categories", categories);

        return "admin/menu/reg";
    }

    @PostMapping("reg")
    public String reg(
            List<MultipartFile> imgs,
            HttpServletRequest request
//            ServletContext context
            , Menu menu
            , @RequestParam("kor-name") String korName
            , @RequestParam("eng-name") String engName
            , @RequestParam("category-id") Long categoryId
    ) {
        menu.setKorName(korName);
        menu.setEngName(engName);
        menu.setCategoryId(categoryId);
        menu.setRegMemberId(1L);

        System.out.println(menu);

        List<MenuImage> images = new ArrayList<>();
        for (MultipartFile img : imgs) {

            if (img.isEmpty()) {
                return "redirect:list";
            }

            String path = request.getServletContext().getRealPath("/image/product");

            File pathFile = new File(path);
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }

            String fileName = img.getOriginalFilename();

//        String fullPath = path + File.separator + fileName;
            String fullPath = Paths.get(pathFile.toString(), fileName).toString();
            System.out.println(fullPath);
            try {
                img.transferTo(new File(fullPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            images.add(MenuImage.builder()
                    .src(fileName)
                    .isDefault(true)
                    .build());
        }
        images.add(MenuImage.builder()
                .src("americano.svg")
                .isDefault(false)
                .build());

        MenuRegDto menuDto = MenuRegDto
                .builder()
                .menu(menu)
                .images(images)
                .build();


        service.reg(menuDto);
//        MenuImage image = new MenuImage();
//        image.setSrc("");
//        menuImageService.reg(image);

        return "redirect:list";
    }

    @GetMapping("del")
    public String del(Long id, Model model) {

        Menu menu = service.getById(id);
        model.addAttribute("menu", menu);

        return "admin/menu/del";
    }

    @PostMapping("del")
    public String delPost(Long id) {

        service.delete(id);

        return "redirect:list";
    }
}
