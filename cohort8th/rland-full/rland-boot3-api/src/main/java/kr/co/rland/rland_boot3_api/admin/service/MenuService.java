package kr.co.rland.rland_boot3_api.admin.service;

import kr.co.rland.rland_boot3_api.admin.dto.MenuResponseDto;

import java.util.List;

public interface MenuService {
        MenuResponseDto getList(Integer page, String korName, List<Long> categoryIds);
}
