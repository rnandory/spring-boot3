package kr.co.rland.rland_boot3_api.admin.menu.dto;

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
    private List<Long> pages;
    private long totalCount;
    private long totalPages;
    private int currentPageRowCount;
    private boolean hasNextPage;
    private boolean hasPreviousPage;
    private List<MenuListDto> menus;
}
