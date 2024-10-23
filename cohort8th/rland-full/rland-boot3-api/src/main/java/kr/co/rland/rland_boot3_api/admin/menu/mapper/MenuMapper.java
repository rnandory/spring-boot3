package kr.co.rland.rland_boot3_api.admin.menu.mapper;

import kr.co.rland.rland_boot3_api.admin.menu.dto.MenuListDto;
import kr.co.rland.rland_boot3_api.entity.Menu;

public class MenuMapper {
    public static MenuListDto mapToDto(Menu menu) {
        if (menu == null)
            return null;

        return MenuListDto.builder()
                .id(menu.getId())
                .korName(menu.getKorName())
                .engName(menu.getEngName())
                .price(menu.getPrice())
                .regDate(menu.getRegDate())
                .categoryId(menu.getCategoryId())
                .regMemberId(menu.getRegMemberId())
                .images(menu.getImages())
                .build();
    }

    public static Menu mapToEntity(MenuListDto dto) {
        if (dto == null)
            return null;

        return Menu.builder()
                .id(dto.getId())
                .korName(dto.getKorName())
                .engName(dto.getEngName())
                .price(dto.getPrice())
                .regDate(dto.getRegDate())
                .categoryId(dto.getCategoryId())
                .regMemberId(dto.getRegMemberId())
                .build();
    }
}
