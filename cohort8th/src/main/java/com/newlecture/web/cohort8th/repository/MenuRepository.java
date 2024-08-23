package com.newlecture.web.cohort8th.repository;

import com.newlecture.web.cohort8th.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuRepository {
//    @Select("SELECT * FROM MENU")
    List<Menu> findAll();
}
