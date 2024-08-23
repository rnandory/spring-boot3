package com.newlecture.web.cohort8th.controller;

import com.newlecture.web.cohort8th.service.CategoryService;
import com.newlecture.web.cohort8th.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("list")
    public String list(Model model) {

        model.addAttribute("menus", menuService.getList());
        model.addAttribute("categories", categoryService.getCategoryList());

        return "menu/list";
    }
}
