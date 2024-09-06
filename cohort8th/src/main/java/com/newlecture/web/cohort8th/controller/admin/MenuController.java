package com.newlecture.web.cohort8th.controller.admin;

import com.newlecture.web.cohort8th.entity.Category;
import com.newlecture.web.cohort8th.entity.Menu;
import com.newlecture.web.cohort8th.service.CategoryService;
import com.newlecture.web.cohort8th.service.MenuService;
import jakarta.servlet.ServletContext;
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
    public String list(Model model) {

        List<Category> categories = categoryService.getList();
        model.addAttribute("categories", categories);

        return "admin/menu/list";
    }

    @GetMapping("reg")
    public String reg(Model model) {

        List<Category> categories = categoryService.getList();
        model.addAttribute("categories", categories);

        return "admin/menu/reg";
    }

    @PostMapping("reg")
    public String reg(
            MultipartFile img,
            HttpServletRequest request
//            ServletContext context
            , Menu menu
            , @RequestParam("kor-name") String korName
            , @RequestParam("eng-name") String engName
            , @RequestParam("category-id") Long categoryId
            ) {

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
//        System.out.println(fullPath);
        try {
            img.transferTo(new File(fullPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        menu.setKorName(korName);
        menu.setEngName(engName);
        menu.setCategoryId(categoryId);
        menu.setRegMemberId(1L);
        menu.setId(6L);

        System.out.println(menu);

        service.reg(menu);

        return "redirect:list";
    }
}
