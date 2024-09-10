package com.newlecture.web.cohort8th.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDetailModel {
    private Menu menu;
    private List<MenuImage> images;
    private List<RcmdMenuView> rcmdMenus;
}
