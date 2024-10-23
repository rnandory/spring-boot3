package kr.co.rland.rland_boot3_api.admin.menu.service;

import kr.co.rland.rland_boot3_api.admin.menu.dto.MenuListDto;
import kr.co.rland.rland_boot3_api.admin.menu.dto.MenuResponseDto;

import java.util.List;

public interface MenuService {
        MenuResponseDto getList(Integer page, String korName, List<Long> categoryIds);
        MenuListDto getById(Long id);
        MenuListDto create(MenuListDto menuListDto);

        // PUT api/v1/admin/menus/3
        // MenuDto + id -> MenuDto : dto에 함께 포함해서 or 따로따로 전달
        MenuListDto update(MenuListDto menuListDto);

        void delete(Long id);
}
