package com.newlecture.web.cohort8th.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.cohort8th.entity.Notice;
import com.newlecture.web.cohort8th.repository.NoticeRepository;

@Service
public class DefaultNoticeService implements NoticeService{

    @Autowired
    private NoticeRepository repository;

    @Override
    public List<Notice> getList() {

        List<Notice> notices = null;
//        try {
//            notices = repository.findAll();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        return null;
    }


    
}
