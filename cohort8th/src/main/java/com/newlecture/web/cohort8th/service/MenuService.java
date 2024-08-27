package com.newlecture.web.cohort8th.service;

import com.newlecture.web.cohort8th.entity.Category;
import com.newlecture.web.cohort8th.entity.Menu;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    List<Menu> getList();
    List<Menu> getList(Integer category);

    List<Menu> getList(Integer categoryId, String query);
}
