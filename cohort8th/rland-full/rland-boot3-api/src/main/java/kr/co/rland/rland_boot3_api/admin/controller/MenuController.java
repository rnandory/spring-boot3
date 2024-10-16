package kr.co.rland.rland_boot3_api.admin.controller;

import kr.co.rland.rland_boot3_api.admin.dto.MenuResponseDto;
import kr.co.rland.rland_boot3_api.admin.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("adminMenuController")
@RequestMapping("admin/menus")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<MenuResponseDto> getList(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "q", required = false) String korName,
            @RequestParam(name = "cid", required = false) List<Long> categoryIds
    ) {

        return ResponseEntity.ok(menuService.getList(page, korName, categoryIds));
    }
}
