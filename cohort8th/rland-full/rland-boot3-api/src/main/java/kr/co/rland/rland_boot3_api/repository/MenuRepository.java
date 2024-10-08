package kr.co.rland.rland_boot3_api.repository;

import kr.co.rland.rland_boot3_api.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
