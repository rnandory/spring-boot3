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
public class Menu {
    private Long id;
    private String korName;
    private String engName;
    private Integer price;
    private Date regDate;
    private String description;
    private Long categoryId;
    private Long regMemberId;
}
