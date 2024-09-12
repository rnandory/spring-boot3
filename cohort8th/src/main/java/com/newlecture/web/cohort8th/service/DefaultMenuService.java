package com.newlecture.web.cohort8th.service;

import com.newlecture.web.cohort8th.dto.MenuRegDto;
import com.newlecture.web.cohort8th.entity.*;
import com.newlecture.web.cohort8th.model.MenuDetailModel;
import com.newlecture.web.cohort8th.repository.MenuImgRepository;
import com.newlecture.web.cohort8th.repository.MenuRepository;
import com.newlecture.web.cohort8th.repository.RcmdMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMenuService implements MenuService {

    @Autowired
    private MenuRepository repository;
    @Autowired
    private MenuImgRepository menuImgRepository;
    @Autowired
    private RcmdMenuRepository rcmdMenuRepository;


    @Override
    public List<MenuView> getList() {

        List<MenuView> menus = getList(null, null, null);
        return menus;
    }

    @Override
    public List<MenuView> getList(Integer category) {

        List<MenuView> menus = getList(category, null, null);
        return menus;
    }

    @Override
    public List<MenuView> getList(Integer category, String query) {

        List<MenuView> menus = getList(category, query, null);
        return menus;
    }

    @Override
    public List<MenuView> getList(Integer categoryId, String query, String order) {
        List<MenuView> menus = repository.findAll(categoryId, query, order);
        return menus;
    }

    @Override
    public Menu getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void reg(MenuRegDto menuDto) {

        Menu menu = menuDto.getMenu();
        List<MenuImage> images = menuDto.getImages();

        System.out.println(images);

        repository.save(menu); // xml : insert

        menuImgRepository.saveAll(images);
    }

    @Override
    public MenuDetailModel getDetailById(Long id) {
        Menu menu = repository.findById(id);
        List<MenuImage> images = menuImgRepository.findAllByMenuId(id);
        List<RcmdMenuView> rcmdMenus= rcmdMenuRepository.findAllByMenuId(id);

        MenuDetailModel model = MenuDetailModel
                .builder()
                .menu(menu)
                .images(images)
                .rcmdMenus(rcmdMenus)
                .build();


        return model;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
