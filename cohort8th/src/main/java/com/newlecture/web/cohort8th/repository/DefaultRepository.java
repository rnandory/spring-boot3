package com.newlecture.web.cohort8th.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.newlecture.web.cohort8th.entity.Notice;

//@Repository
public class DefaultRepository implements NoticeRepository {

    @Override
    public List<Notice> findAll() {
                
        List<Notice> list = new ArrayList<Notice>();

//        list.add(new Notice(1, "title1", "content1"));
//        list.add(new Notice(2, "title2", "content2"));
//        list.add(new Notice(3, "title3", "content3"));
        
        return list;
    }
    
}
