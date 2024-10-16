package kr.co.rland.rland_boot3_api.admin.service;

import kr.co.rland.rland_boot3_api.admin.dto.MenuDto;
import kr.co.rland.rland_boot3_api.admin.dto.MenuResponseDto;
import kr.co.rland.rland_boot3_api.admin.mapper.MenuMapper;
import kr.co.rland.rland_boot3_api.entity.Menu;
import kr.co.rland.rland_boot3_api.repository.MenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminMenuService")
public class DefaultMenuService implements MenuService {

    private MenuRepository menuRepository;

    public DefaultMenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public MenuResponseDto getList(Integer page, String korName, List<Long> categoryIds) {
        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(page-1, 6, sort);

//        Page<Menu> menuPage = menuRepository.findAll(pageable);
        Page<Menu> menuPage = menuRepository.findAll(korName, categoryIds, pageable);

        List<MenuDto> menuDtos = menuPage
                .getContent()
                .stream()
                .map(MenuMapper::mapToDto)
                .toList();

        long totalCount = menuPage.getTotalElements();
        int totalPages = menuPage.getTotalPages();

        return MenuResponseDto.builder()
                .totalCount(totalCount)
                .totalPages(totalPages)
                .menus(menuDtos)
                .build();
    }
}
