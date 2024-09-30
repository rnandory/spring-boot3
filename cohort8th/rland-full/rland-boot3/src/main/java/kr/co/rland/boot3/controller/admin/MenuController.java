package kr.co.rland.boot3.controller.admin;

import kr.co.rland.boot3.dto.MenuRegDto;
import kr.co.rland.boot3.entity.Menu;
import kr.co.rland.boot3.entity.MenuImage;
import kr.co.rland.boot3.entity.MenuView;
import kr.co.rland.boot3.model.MenuDetailModel;
import kr.co.rland.boot3.service.MenuImageService;
import kr.co.rland.boot3.service.MenuService;
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
import java.util.ArrayList;
import java.util.List;

@Controller("adminMenuController")
@RequestMapping("admin/menu")
public class MenuController {

    private MenuService service;
    private MenuImageService imageService;

    @Autowired
    public MenuController(MenuService menuService, MenuImageService menuImageService) {
        this.service = menuService;
        this.imageService = menuImageService;
    }

    @GetMapping("list")
    public String list(Model model){

        List<MenuView> menus = service.getListWithImages(null, null);
        model.addAttribute("menus", menus);

        return "admin/menu/list";
    }

    @GetMapping("detail")
    public String detail(Long id, Model model){

        // 1 번 방법 : 서비스가 모든 것을 하나의 그릇에 담아서 넘겨주기
        MenuDetailModel menuModel = service.getDetailById(id);
//        model.addAttribute("menuModel", menuModel);
        model.addAttribute("menu", menuModel.getMenu());
        model.addAttribute("imgs", menuModel.getImages());
        model.addAttribute("rcmds", menuModel.getRcmdMenus());


        // 2번 방법 : 컨트롤러가 서비스를 각각 활용해서 그릇에 담기
//        Menu menu = service.getById(id);
//        MenuImage img = menuImageService.getByMenuId(id);
//        List<RcmdMenu> rcmdMenus = rcmdMenuService.getListByMenuId(id);
//
//        model.addAttribute("menu", menu);
//        model.addAttribute("img", img);
//        model.addAttribute("rcmdMenus", rcmdMenus);

        return "admin/menu/detail";
    }

    @GetMapping("reg")
    public String reg(){
        return "admin/menu/reg";
    }

    @PostMapping("reg")
    public String reg(
            List<MultipartFile> imgs,
            HttpServletRequest request,
//            ServletContext context
            Menu menu,
            @RequestParam("kor-name")
            String korName,
            @RequestParam("eng-name")
            String engName,
            @RequestParam("category-id")
            Long categoryId
    ){
        menu.setCategoryId(categoryId);
        menu.setKorName(korName);
        menu.setEngName(engName);
        menu.setRegMemberId(1L);

        System.out.println(menu);
        List<MenuImage> images = new ArrayList<>();

        for(MultipartFile img : imgs){


            if(img.isEmpty())
                return "redirect:list";

            String path = request.getServletContext().getRealPath("/image/product");
            System.out.println(path);

            File pathFile = new File(path);;
            if(!pathFile.exists())
                pathFile.mkdirs();

            String fileName = img.getOriginalFilename();
    //        String fullPath = path + File.separator + fileName;

            String fullPath = Paths.get(path, fileName).toString();

            try {
                img.transferTo(new File(fullPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            images.add(
                    MenuImage.builder()
                            .src(fileName)
                            .isDefault(true)
                            .build());
        }

        images.add(
                MenuImage.builder()
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
//        menuImageservice.reg(image);

        return "redirect:list";
    }

    @GetMapping("del")
    public String del(Long id, Model model){

//        Menu menu = service.getById(id);
//        model.addAttribute("menu", menu);
        model.addAttribute("id", id);

        return "admin/menu/del";
    }

    @PostMapping("del")
    public String del(Long id){

        service.deleteById(id);

        return "redirect:list";
    }
}
