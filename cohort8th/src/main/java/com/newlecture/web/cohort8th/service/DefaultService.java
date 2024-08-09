package com.newlecture.web.cohort8th.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.cohort8th.entity.Notice;
import com.newlecture.web.cohort8th.repository.NoticeRepository;

@Service
public class DefaultService implements NoticeService{

    @Autowired
    private NoticeRepository repository;

    @Override
    public List<Notice> getList() throws SQLException, ClassNotFoundException {
                
        List<Notice> list = repository.findAll();

        return list;
    }
    
}
