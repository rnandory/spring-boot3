package kr.co.rland.rland_boot3_api.admin.service;

import kr.co.rland.rland_boot3_api.admin.dto.MenuDto;
import kr.co.rland.rland_boot3_api.admin.dto.MenuResponseDto;
import kr.co.rland.rland_boot3_api.admin.mapper.MenuMapper;
import kr.co.rland.rland_boot3_api.entity.Menu;
import kr.co.rland.rland_boot3_api.entity.MenuImage;
import kr.co.rland.rland_boot3_api.repository.MenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
        long totalPages = menuPage.getTotalPages();
        boolean hasNextPage = menuPage.hasNext();
        boolean hasPreviousPage = menuPage.hasPrevious();
        List<Long> pages = new ArrayList<>();
//        let page = useRoute().query.p || 1; // 기본값 1
//        let offset = (page - 1) % 5;
//        startNum.value = page - offset;
//        let nums = Array.from({ length: 5 }, (_, i) => i + startNum.value);
        page = (page == null)? 1 : page;
        int offset = (page - 1) % 5;
        int startNUm = page - offset;
        pages = IntStream.range(startNUm, startNUm + 5)
                .boxed()
                .map(Long::valueOf)
                .toList();

        return MenuResponseDto.builder()
                .totalCount(totalCount)
                .totalPages(totalPages)
                .hasNextPage(hasNextPage)
                .hasPreviousPage(hasPreviousPage)
                .menus(menuDtos)
                .pages(pages)
                .build();
    }

    @Override
    public MenuDto getById(Long id) {

        Menu menu = menuRepository.findById(id).orElseThrow();

        MenuDto menuDto = MenuMapper.mapToDto(menu);

        return menuDto;
    }

    // POST api/v1/admin/menus/
    @Override
    public MenuDto create(MenuDto menuDto) {

        Menu menu = menuRepository.save(MenuMapper.mapToEntity(menuDto));

//        Menu newOne = menuRepository.findById(menuDto.getId()).orElseThrow();

        return MenuMapper.mapToDto(menu);
    }

    // PUT api/v1/admin/menus/3
    // MenuDto + id -> MenuDto : dto에 함께 포함해서 or 따로따로 전달

    // transaction 고립도
    // - uncommitted - dirty read
    // - committed - phantom
    // -
    @Override
    @Transactional
    public MenuDto update(MenuDto menuDto) {

        Menu menu = menuRepository.findById(menuDto.getId()).orElseThrow();

        // if (menuDto.getKorName());
        if (menuDto.getKorName() != null)
            menu.setKorName(menuDto.getKorName());

        if (menuDto.getEngName() != null)
            menu.setEngName(menuDto.getEngName());

//        menu.setRegDate(menuDto.getRegDate()); // Entity에 @UpdateTimeStamp설정

        if (menuDto.getPrice() != null)
            menu.setPrice(menuDto.getPrice());

        if (menuDto.getRegMemberId() != null)
            menu.setRegMemberId(menuDto.getRegMemberId());

        if (menuDto.getImages() != null) {
            menu.getImages().addAll(menuDto.getImages());
        }

        menuRepository.save(menu);

        Menu updatedMenu = menuRepository.findById(menuDto.getId()).orElseThrow();

        return MenuMapper.mapToDto(updatedMenu);
    }

    @Override
    public void delete(Long id) {
        menuRepository.deleteById(id);
    }
}
