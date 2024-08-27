package com.newlecture.web.cohort8th.service;

import com.newlecture.web.cohort8th.entity.Category;
import com.newlecture.web.cohort8th.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCategoryService implements CategoryService{
    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getList() {

        List<Category> list = repository.findAll();
        return list;
    }
}
