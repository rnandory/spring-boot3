package com.newlecture.web.cohort8th.repository;

import java.util.List;

import com.newlecture.web.cohort8th.entity.Notice;

public interface NoticeRepository {
    List<Notice> findAll();
}
