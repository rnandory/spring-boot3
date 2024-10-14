package kr.co.rland.rland_boot3_api.repository;

import kr.co.rland.rland_boot3_api.entity.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MenuRepositoryTest {

    @Autowired
    private MenuRepository repository;

    @Test
    void queryTest() {
        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(0, 6, sort);
//        List<Menu> menus = repository.findxxx(?, pageable).getContent();
        List<Menu> menus = repository.findByKorNameContaining("아메", pageable);
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