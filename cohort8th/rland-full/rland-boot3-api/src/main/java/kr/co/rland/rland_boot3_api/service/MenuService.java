package kr.co.rland.rland_boot3_api.service;

import kr.co.rland.rland_boot3_api.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MenuService {
    List<Menu> getList();
}
