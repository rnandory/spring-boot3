package kr.co.rland.rland_boot3_api.anonymous.menu.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDto {

    private Long id;
    private String korName;
    private String engName;
    private Integer price;
    private LocalDateTime regDate;
    private Long categoryId;
    private Long regMemberId;

    // MenuView처럼 목록을 표현할 때 추가적으로 필요한 속성을 확장
    private String defaultImage;

    // private List<MenuImage> images;
}
