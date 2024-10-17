package kr.co.rland.rland_boot3_api.admin.service;

import kr.co.rland.rland_boot3_api.admin.dto.MenuDto;
import kr.co.rland.rland_boot3_api.admin.dto.MenuResponseDto;

import java.util.List;

public interface MenuService {
        MenuResponseDto getList(Integer page, String korName, List<Long> categoryIds);
        MenuDto getById(Long id);
        MenuDto create(MenuDto menuDto);

        // PUT api/v1/admin/menus/3
        // MenuDto + id -> MenuDto : dto에 함께 포함해서 or 따로따로 전달
        MenuDto update(MenuDto menuDto);

        void delete(Long id);
}
