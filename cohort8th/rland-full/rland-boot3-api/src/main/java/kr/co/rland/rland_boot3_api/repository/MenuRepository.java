package kr.co.rland.rland_boot3_api.repository;

import kr.co.rland.rland_boot3_api.entity.Menu;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("select m, mi.id, mi.src from Menu m left join MenuImage mi on m.id = mi.menu.id where mi.isDefault=true")
    List<Menu> findAllByDefaultImage(Pageable pageable);
//    List<Menu> findByKorNameAndCategoryIdIn(String korName, Long categoryIds, Pageable pageable);

    // 사용자가 입력한 값이 korName과 같은 Menu목록만 출력
    // 단 1페이지, regdate로 내림차순
    List<Menu> findByKorName(String korName, Pageable pageable);
    List<Menu> findByKorNameLike(String korName, Pageable pageable);
    List<Menu> findByKorNameContaining(String korName, Pageable pageable);
    List<Menu> findByKorNameContainingAndPriceGreaterThanEqualAndCategoryIdIn(String korName, int price, List<Long> categoryIds, Pageable pageable);

    @Query("from Menu where " +
            "(:username is null or korName like concat('%', :username, '%'))" +
            "and (:price is null or price >= :price) " +
            "and (:cIds is null or categoryId in (:cIds))")
    List<Menu> findByQuery(@Param("username") String korName, @Param("price") Integer price, @Param("cIds") List<Long> categoryIds, Pageable pageable);

    // 등록된지 한달 이내의 메뉴만 조회
    List<Menu> findByRegDateBetween(Instant start, Instant end, Pageable pageable);
    // List<Menu> findByRegDateBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);

    // 메뉴 검색 목록(이미 있긴한데 - findAll)
    // 규칙 1: findBy + 정렬 + 필터링
    List<Menu> findByOrderByRegDateDesc();

    // 메뉴 상세(이미 있음 - findById)

    // 메뉴 등록(이미 있음 - save)

    // 메뉴 수정(이미 있음 -save)

    // 메뉴 삭제(이미 있음 - delete)
}
