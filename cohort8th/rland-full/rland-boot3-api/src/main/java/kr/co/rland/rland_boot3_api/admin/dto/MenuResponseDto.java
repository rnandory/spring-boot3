package kr.co.rland.rland_boot3_api.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuResponseDto {
    private long totalCount;
    private int totalPages;
    private List<MenuDto> menus;

}