package com.newlecture.web.cohort8th.model;

import com.newlecture.web.cohort8th.entity.Menu;
import com.newlecture.web.cohort8th.entity.MenuImage;
import com.newlecture.web.cohort8th.entity.RcmdMenuView;
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