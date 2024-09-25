package com.newlecture.web.cohort8th.controller.api;

import com.newlecture.web.cohort8th.entity.MenuView;
import com.newlecture.web.cohort8th.service.CategoryService;
import com.newlecture.web.cohort8th.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("apiMenuController")
public class MenuController {
    @Autowired
    private MenuService service;
    @Autowired
    private CategoryService categoryService;

    /*
    method  url                     payload
    GET     api/menus?c=1&q=ame         x
    GET     api/menu/3                  x
    POST    api/menus               menu{}
    PUT     api/menu/3              menu{}
    DELETE  api/menu/3              [menu{}]

    url: page명처럼 행위가 아니라 what(어떤 data?)
    => Rest방식으로 명명. like 주소체계.
        상위 ... 하위포함관계 순서 지킬 것!
        행위명을 쓰면 안된다! 행위는 이미 method에 묻어있다

    RESTful API? vs REST API
    행위명을 가급적 자제하겠지만, 필요에 의해서 행위명을 쓸 수도 있다
     */
    @GetMapping("api/menus")
    public List<MenuView> getList(
            Model model,
            @RequestParam(name = "c", required = false)
            Integer categoryId,

            @RequestParam(name = "q", required = false)
            String query,

            @RequestParam(name = "order", required = false)
            String order
    ) {

        List<MenuView> menus = service.getList(categoryId, query, order);

        return menus;
    }
}
