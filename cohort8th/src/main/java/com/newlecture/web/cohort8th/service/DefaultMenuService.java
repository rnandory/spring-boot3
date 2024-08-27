package com.newlecture.web.cohort8th.service;

import com.newlecture.web.cohort8th.entity.Category;
import com.newlecture.web.cohort8th.entity.Menu;
import com.newlecture.web.cohort8th.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DefaultMenuService implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public List<Menu> getList() {

        List<Menu> menus = getList(null, null);
        return menus;
    }

    @Override
    public List<Menu> getList(Integer category) {

        List<Menu> menus = getList(category, null);
        return menus;
    }

    @Override
    public List<Menu> getList(Integer categoryId, String query) {
        List<Menu> menus = repository.findAll(categoryId, query);
        return menus;
    }
}
