package kr.co.rland.rland_boot3_api.anonymous.menu.service;

import kr.co.rland.rland_boot3_api.entity.Menu;
import kr.co.rland.rland_boot3_api.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultMenuService implements MenuService {

    private MenuRepository menuRepository;

    @Override
    public List<Menu> getList() {
        return menuRepository.findAll();
    }
}