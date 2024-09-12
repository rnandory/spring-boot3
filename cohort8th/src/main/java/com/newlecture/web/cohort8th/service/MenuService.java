package com.newlecture.web.cohort8th.service;

import com.newlecture.web.cohort8th.dto.MenuRegDto;
import com.newlecture.web.cohort8th.entity.Menu;
import com.newlecture.web.cohort8th.model.MenuDetailModel;
import com.newlecture.web.cohort8th.entity.MenuView;

import java.util.List;

public interface MenuService {
    List<MenuView> getList();
    List<MenuView> getList(Integer category);

    List<MenuView> getList(Integer categoryId, String query);

    List<MenuView> getList(Integer categoryId, String query, String order);

    void reg(MenuRegDto menuDeto);

    MenuDetailModel getDetailById(Long id);

    void delete(Long id);

    Menu getById(Long id);
}
