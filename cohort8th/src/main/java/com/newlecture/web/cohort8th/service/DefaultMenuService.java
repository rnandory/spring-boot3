package com.newlecture.web.cohort8th.service;

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
    MenuRepository repository;

    @Override
    public List<Menu> getList() {

        try{
            List<Menu> list = repository.findAll();
            return list;
        }
        catch (Exception e) {
            System.out.println("menu service: menu repo findAll 에러발생");
        }

        return null;
    }
}
