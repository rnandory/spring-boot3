package kr.co.rland.rland_boot3_api.repository;

import kr.co.rland.rland_boot3_api.entity.Menu;
import org.springframework.data.domain.Page;

public interface MenuCustomRepository {
    Page<Menu> findAllMenus(String korName, Integer price, Integer page, Integer size);
}
