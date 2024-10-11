package kr.co.rland.rland_boot3_api.controller;

import kr.co.rland.rland_boot3_api.dto.MenuDto;
import kr.co.rland.rland_boot3_api.entity.Menu;
import kr.co.rland.rland_boot3_api.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/menus")
@AllArgsConstructor
public class MenuController {

    private MenuService service;
    private ListCrudRepository<Menu, Long> repository;


//    public MenuController(MenuService service) {
//        this.service = service;
//    }







    // api/v1/menus?p=1&s=10
    @GetMapping
    public List<Menu> getList(
            @RequestParam(name = "p", defaultValue = "1", required = false) int page,
            @RequestParam(name = "s", defaultValue = "6", required = false) int size
    ) {
//        return service.getList();
        return repository.findAll();
    }

    // api/v1/menus/{1}
    // api/v1/menus/{1}/korname
    // api/v1/menus/{1}/{korname}
    @GetMapping("{id}")
    public ResponseEntity<MenuDto> get(
            @PathVariable("id") Long id) {

        System.out.println(id);

        MenuDto menu = MenuDto.builder().korName("맛난 커피1").build();

//        return ResponseEntity.ok().body(menu);
//        return ResponseEntity.ok(menu);

//        return  ResponseEntity.ok()
//                .header("new-line", "12")
//                .body(menu);

        return new ResponseEntity<>(menu, HttpStatus.OK); // 상태 옵션이 더 많이 보임

//        return Menu.builder().korName("맛난 커피1").build();
    }


    @PostMapping()
    public ResponseEntity<MenuDto> create(
            @RequestBody MenuDto menuDto) {

        System.out.println(menuDto);

        // 서버에 저장
        // 저장한 걸 반환
        MenuDto newOne = MenuDto.builder().korName(menuDto.getKorName()).build();

        return new ResponseEntity<>(newOne, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<MenuDto> update(
            MenuDto menuDto,
            @PathVariable("id") Long id) {

        menuDto.setKorName("방금 수정된 맛난 커피1");

        return new ResponseEntity<>(menuDto, HttpStatus.OK);
    }

//        @PutMapping("{id}/price")
//        public ResponseEntity<MenuDto> updatePrice(MenuDto menuDto) {
//
//            menuDto.setKorName("방금 수정된 맛난 커피1");
//
//            return new ResponseEntity<>(menuDto, HttpStatus.OK);
//        }
//
//        @PutMapping("{id}/price/{price}")
//        public ResponseEntity<MenuDto> updatePriceWithValue(MenuDto menuDto) {
//
//            menuDto.setKorName("방금 수정된 맛난 커피1");
//
//            return new ResponseEntity<>(menuDto, HttpStatus.OK);
//        }

    // 1번 메뉴의 메뉴이미지 변경
    // api/v1/menus/1/menuImages/2
//    @PutMapping("{id}/menuImages/{mId}")
//    public ResponseEntity<MenuDto> updateImage(MenuDto menuDto) {
//
//        menuDto.setDefaultImage("방금 수정된 맛난 커피1 이미지");
//
//        return new ResponseEntity<>(menuDto, HttpStatus.OK);
//    }

    // 3번 회원이 등록한
    // 메뉴 2번
    // 그 메뉴의 이미지를 등록하는 url? 그걸 담당할 controller는?
    // -> api/v1/menus/{2}/member/{memberId}/menuImages : menuImages controller
    // -> api/v1/members/{memberId}/menus/{menuId}/menuImages : member controller

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(
            @PathVariable("id") Long id) {

        System.out.println(String.format("%d번 항목이 삭제되었습니다.", id));

        return new ResponseEntity<>("successfully deleted" ,HttpStatus.OK);
    }













}
