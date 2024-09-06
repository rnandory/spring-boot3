package com.newlecture.web.cohort8th.service;

import com.newlecture.web.cohort8th.entity.Category;
import com.newlecture.web.cohort8th.entity.Menu;
import com.newlecture.web.cohort8th.entity.MenuView;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    List<MenuView> getList();
    List<MenuView> getList(Integer category);

    List<MenuView> getList(Integer categoryId, String query);

    List<MenuView> getList(Integer categoryId, String query, String order);

    void reg(Menu menu);
}
