package com.newlecture.web.cohort8th.repository;

import com.newlecture.web.cohort8th.entity.Menu;

import java.sql.SQLException;
import java.util.List;

public interface MenuRepository {
    List<Menu> findAll();
}
