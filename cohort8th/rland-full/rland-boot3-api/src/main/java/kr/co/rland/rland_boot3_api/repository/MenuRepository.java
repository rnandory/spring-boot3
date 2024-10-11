package kr.co.rland.rland_boot3_api.repository;

import kr.co.rland.rland_boot3_api.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    // 메뉴 검색 목록(이미 있긴한데 - findAll)
    // 규칙 1: findBy + 정렬 + 필터링
    List<Menu> findByOrderByRegDateDesc();

    // 메뉴 상세(이미 있음 - findById)

    // 메뉴 등록(이미 있음 - save)

    // 메뉴 수정(이미 있음 -save)

    // 메뉴 삭제(이미 있음 - delete)
}
