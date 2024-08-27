package com.newlecture.web.cohort8th.repository;

import com.newlecture.web.cohort8th.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryRepository {
    List<Category> findAll();
}
