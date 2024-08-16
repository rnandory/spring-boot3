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
    private long id;
    private String korName;
    private String engName;
    private int price;
    private String img;
    private Date regDate;
    private long categoryId;
    private long regMemberId;
}
