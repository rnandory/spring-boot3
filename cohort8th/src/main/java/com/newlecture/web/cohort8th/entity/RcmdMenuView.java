package com.newlecture.web.cohort8th.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RcmdMenuView {
    private Long id;
    private Long menuId;
    private Long rMenuId;
    private Long memberId;

    private String img;
    private String korName;
    private String engName;
    private Integer price;

}
