package com.newlecture.web.cohort8th.service;

import com.newlecture.web.cohort8th.entity.Menu;
import com.newlecture.web.cohort8th.entity.MenuView;
import com.newlecture.web.cohort8th.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMenuService implements MenuService {

    @Autowired
    private MenuRepository repository;

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
    public List<MenuView> getList(Integer category,String query) {

        List<MenuView> menus = getList(category, query, null);
        return menus;
    }

    @Override
    public List<MenuView> getList(Integer categoryId, String query, String order) {
        List<MenuView> menus = repository.findAll(categoryId, query, order);
        return menus;
    }
}
