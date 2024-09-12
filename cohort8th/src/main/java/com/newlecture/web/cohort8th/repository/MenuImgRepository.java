package com.newlecture.web.cohort8th.repository;

import com.newlecture.web.cohort8th.entity.MenuImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuImgRepository {
    List<MenuImage> findAllByMenuId(Long id);
    MenuImage findDefaultByMenuId(Long id);

    void saveAll(List<MenuImage> images);
}
