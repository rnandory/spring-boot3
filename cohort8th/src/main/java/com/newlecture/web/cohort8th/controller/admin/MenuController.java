package com.newlecture.web.cohort8th.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller("adminMenuController")
@RequestMapping("admin/menu")
public class MenuController {

    @GetMapping("list")
    public String list() {
        return "admin/menu/list";
    }

    @GetMapping("reg")
    public String reg() {
        return "admin/menu/reg";
    }

    @PostMapping("reg")
    public String reg(
            MultipartFile img
//            Menu menu
            ) {

        if (!img.isEmpty()) {
            return "admin/menu/reg";
        }

        String fileName = img.getOriginalFilename();

//        img.transferTo(new File(fileName));


        return "redirect:list";
    }
}
