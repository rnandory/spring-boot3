package kr.co.rland.rland_boot3_api.admin.repository;

import kr.co.rland.rland_boot3_api.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminMenuRepository extends JpaRepository<Menu, Long> {
}
