package kr.co.rland.rland_boot3_api.controller;

import kr.co.rland.rland_boot3_api.entity.Menu;
import kr.co.rland.rland_boot3_api.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/menus")
public class MenuController {

    private MenuService service;


    public MenuController(MenuService service) {
        this.service = service;
    }

    @GetMapping
    public List<Menu> getList() {
        return service.getList();
    }
}
