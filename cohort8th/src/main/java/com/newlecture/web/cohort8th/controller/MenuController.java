package com.newlecture.web.cohort8th.controller;

import com.newlecture.web.cohort8th.entity.Category;
import com.newlecture.web.cohort8th.entity.Menu;
import com.newlecture.web.cohort8th.entity.MenuView;
import com.newlecture.web.cohort8th.service.CategoryService;
import com.newlecture.web.cohort8th.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService service;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("list")
    public String list(
            Model model,
            @RequestParam(name = "c", required = false)
            Integer categoryId,

            @RequestParam(name = "q", required = false)
            String query,

            @RequestParam(name = "order", required = false)
            String order
    ) {

        List<Category> categories = categoryService.getList();
        List<MenuView> menus = service.getList(categoryId, query, order);

        model.addAttribute("currentCategory", categoryId);
        model.addAttribute("menus", menus);
        model.addAttribute("categories", categories);

        return "menu/list";
    }
}
