package kr.co.rland.rland_boot3_api.admin.menu.service;

import kr.co.rland.rland_boot3_api.admin.menu.dto.MenuListDto;
import kr.co.rland.rland_boot3_api.admin.menu.dto.MenuResponseDto;
import kr.co.rland.rland_boot3_api.admin.menu.mapper.MenuMapper;
import kr.co.rland.rland_boot3_api.entity.Menu;
import kr.co.rland.rland_boot3_api.repository.MenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
//        Page<Menu> menuPage = menuRepository.findAll(korName, categoryIds, pageable);
        Page<Menu> menuPage = menuRepository.findAllMenus(korName, 0, page, 6);


        List<MenuListDto> menuListDtos = menuPage
                .getContent()
                .stream()
                .map(MenuMapper::mapToDto)
                .toList();


        long totalCount = menuPage.getTotalElements();
        long totalPages = menuPage.getTotalPages();
        int currentPageRowCount = menuPage.getNumberOfElements();
        boolean hasNextPage = menuPage.hasNext();
        boolean hasPreviousPage = menuPage.hasPrevious();
        List<Long> pages = new ArrayList<>();
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
                .currentPageRowCount(currentPageRowCount)
                .hasNextPage(hasNextPage)
                .hasPreviousPage(hasPreviousPage)
                .menus(menuListDtos)
                .pages(pages)
                .build();
    }

    @Override
    public MenuListDto getById(Long id) {

        Menu menu = menuRepository.findById(id).orElseThrow();

        MenuListDto menuListDto = MenuMapper.mapToDto(menu);

        return menuListDto;
    }

    // POST api/v1/admin/menus/
    @Override
    public MenuListDto create(MenuListDto menuListDto) {

        Menu menu = menuRepository.save(MenuMapper.mapToEntity(menuListDto));

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
    public MenuListDto update(MenuListDto menuListDto) {

        Menu menu = menuRepository.findById(menuListDto.getId()).orElseThrow();

        // if (menuDto.getKorName());
        if (menuListDto.getKorName() != null)
            menu.setKorName(menuListDto.getKorName());

        if (menuListDto.getEngName() != null)
            menu.setEngName(menuListDto.getEngName());

//        menu.setRegDate(menuDto.getRegDate()); // Entity에 @UpdateTimeStamp설정

        if (menuListDto.getPrice() != null)
            menu.setPrice(menuListDto.getPrice());

        if (menuListDto.getRegMemberId() != null)
            menu.setRegMemberId(menuListDto.getRegMemberId());

        if (menuListDto.getImages() != null) {
            menu.getImages().addAll(menuListDto.getImages());
        }

        menuRepository.save(menu);

        Menu updatedMenu = menuRepository.findById(menuListDto.getId()).orElseThrow();

        return MenuMapper.mapToDto(updatedMenu);
    }

    @Override
    public void delete(Long id) {
        menuRepository.deleteById(id);
    }
}
