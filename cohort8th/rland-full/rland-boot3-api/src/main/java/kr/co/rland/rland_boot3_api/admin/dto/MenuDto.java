package kr.co.rland.rland_boot3_api.admin.dto;

import kr.co.rland.rland_boot3_api.entity.MenuImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDto {
    private Long id;
    private String korName;
    private String engName;
    private Integer price;
    private Instant regDate;

    private Long categoryId;
    private Long regMemberId;

    //1. 컬렉션
    private List<MenuImage> images;

    //2.

    //3.
}
