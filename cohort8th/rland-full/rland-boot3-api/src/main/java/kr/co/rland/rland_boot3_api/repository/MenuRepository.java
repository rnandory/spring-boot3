package kr.co.rland.rland_boot3_api.repository;

import kr.co.rland.rland_boot3_api.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    // 사용자가 입력한 값이 korName과 같은 Menu목록만 출력
    // 단 1페이지, regdate로 내림차순
    List<Menu> findByKorName(String korName, Pageable pageable);
    List<Menu> findByKorNameLike(String korName, Pageable pageable);
    List<Menu> findByKorNameContaining(String korName, Pageable pageable);

    // 메뉴 검색 목록(이미 있긴한데 - findAll)
    // 규칙 1: findBy + 정렬 + 필터링
    List<Menu> findByOrderByRegDateDesc();

    // 메뉴 상세(이미 있음 - findById)

    // 메뉴 등록(이미 있음 - save)

    // 메뉴 수정(이미 있음 -save)

    // 메뉴 삭제(이미 있음 - delete)
}
