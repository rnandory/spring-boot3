package com.newlecture.web.cohort8th.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuView {
    private Long id;
    private String korName;
    private String engName;
    private Integer price;
    private Date regDate;
    private Long categoryId;
    private Long regMemberId;

    private String categoryName;
    private String img;

    private Integer likeCount;

//    private List<MenuImage> imgs;

}
