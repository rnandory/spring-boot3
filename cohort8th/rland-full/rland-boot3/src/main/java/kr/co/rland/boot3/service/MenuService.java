package kr.co.rland.boot3.service;

import kr.co.rland.boot3.dto.MenuRegDto;
import kr.co.rland.boot3.entity.Menu;
import kr.co.rland.boot3.entity.MenuView;
import kr.co.rland.boot3.model.MenuDetailModel;

import java.util.List;

public interface MenuService {
    List<MenuView> getList();
    List<MenuView> getList(Integer categoryId);
    List<MenuView> getList(Integer categoryId, String query);
    List<MenuView> getListWithImages(Integer categoryId, String query);

    void reg(MenuRegDto menuDto);

    Menu getById(Long id);

    MenuDetailModel getDetailById(Long id);

    void deleteById(Long id);
}
