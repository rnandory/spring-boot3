package kr.co.rland.rland_boot3_api.repository;

import kr.co.rland.rland_boot3_api.entity.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MenuRepositoryTest {

    @Autowired
    private MenuRepository repository;

    @Test
    void joinTest() {
        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(0, 6, sort);
//        List<Menu> menus = repository.findAll();
        List<Menu> menus = repository.findAllByDefaultImage(pageable);

//        menus.forEach(System.out::println);
    }

    @Test
    void queryTest() {
        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(0, 6, sort);
//        List<Menu> menus = repository.findxxx(?, pageable).getContent();
//        List<Menu> menus = repository.findByKorNameContaining("아", pageable);
//        List<Menu> menus = repository
//                .findByKorNameContainingAndPriceGreaterThanEqualAndCategoryIdIn("아", 4000, Arrays.asList(1L,2L,3L), pageable);
        List<Menu> menus = repository.findByQuery("아메", null, null, pageable);
//
//        //=== Menu엔티티에 regDate타입이 Instant일 때=================================================================================
//        // 현재 Instant
//        Instant now = Instant.now();
//
//        // Instant를 LocalDateTime으로 변환
//        LocalDateTime nowDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
//
//        // 한 달 전 날짜 계산 (Period 사용)
//        LocalDateTime oneMonthAgoDateTime = nowDateTime.minus(Period.ofMonths(1));
//
//        // 다시 LocalDateTime을 Instant로 변환
//        Instant oneMonthAgo = oneMonthAgoDateTime.atZone(ZoneId.systemDefault()).toInstant();
//
//        System.out.printf("now : %s\n", now);
//        System.out.printf("one month ago : %s\n", oneMonthAgo);
//        Instant start = now.minus(30, ChronoUnit.DAYS);
//        System.out.printf("start : %s\n", start);
//
//        List<Menu> menus = repository.findByRegDateBetween(start, now, pageable);

        //=== Menu엔티티에 regDate타입이 LocalDateTime일 때=================================================================================
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime start = now.minus(1, ChronoUnit.MONTHS);
//        System.out.printf("now : %s\n", now);
//        System.out.printf("one month ago : %s\n", start);
//
//        List<Menu> menus = repository.findByRegDateBetween(start, now, pageable);

        menus.forEach(System.out::println);
    }

    @Test
    void streamTest() {
//        List<Menu> list = repository.findAll();
        List<Menu> list = repository.findAll()
                .stream()
                .filter(menu -> menu.getPrice() >= 5000)
                .toList();

        list.forEach(menu -> System.out.println(menu.toString()));
//        System.out.println(list);

    }

    @Test
    void findAllTest() {


        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(0, 6, sort);
//        Sort sort = Sort.by(Sort.Direction.DESC, "korName");
//        List<Menu> menus = repository.findByOrderByRegDateDesc();
        Page<Menu> menuPages = repository.findAll(pageable);
        List<Menu> menus = menuPages.getContent();
        System.out.println(menus);

        // 6개씩 나누었을 때 페이지 개수
        int count = menuPages.getTotalPages();
        System.out.println(count);
        // 전체 레코드 개수
        long totalRowCount = menuPages.getTotalElements();
        System.out.println(totalRowCount);
        // 다음 페이지는 있는거야?
        boolean hasNextPage = menuPages.hasNext();
        System.out.println(hasNextPage);
        // 이전 페이지는 있는거야?
        boolean hasPreviousPage = menuPages.hasPrevious();
        System.out.println(hasPreviousPage);
        // 현재 페이지는 몇개의 레코드를 가졌지?
        int currentPageRowCount = menuPages.getNumberOfElements();
        System.out.println(currentPageRowCount);

    }

}