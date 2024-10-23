package kr.co.rland.rland_boot3_api.admin.menu.controller;

import kr.co.rland.rland_boot3_api.admin.menu.dto.MenuListDto;
import kr.co.rland.rland_boot3_api.admin.menu.dto.MenuResponseDto;
import kr.co.rland.rland_boot3_api.admin.menu.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("adminMenuController")
@RequestMapping("admin/menus")
//@CrossOrigin(origins = "http://localhost:5173")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<MenuResponseDto> getList(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "k", required = false) String korName,
            @RequestParam(name = "cid", required = false) List<Long> categoryIds
    ) {

        return ResponseEntity.ok(menuService.getList(page, korName, categoryIds));
    }

    // api/v1/admin/menus/3
    @GetMapping("{id}")
    public ResponseEntity<MenuListDto> get(@PathVariable("id") Long id) {

        return ResponseEntity.ok(menuService.getById(id));
    }

    // api/v1/admin/menus/create
    @PostMapping
    public ResponseEntity<MenuListDto> create(@RequestBody MenuListDto menuListDto) {
        System.out.println(menuListDto);

        return ResponseEntity.ok(menuService.create(menuListDto));
    }

    // 수정 update()
    // api/v1/admin/menus/update/3
    @PutMapping("{id}")
    public ResponseEntity<MenuListDto> update(@PathVariable("id") Long id,
                                              @RequestBody MenuListDto menuListDto) {
        menuListDto.setId(id);
        return ResponseEntity.ok(menuService.update(menuListDto));
    }

    // 삭제 delete()
    @DeleteMapping("{id")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        menuService.delete(id);
        return ResponseEntity.ok("Successfully deteleted");
    }

}
