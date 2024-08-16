package com.newlecture.web.cohort8th.entity;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notice {
    private long id;
    private String title;
    private String content;
    private Date regDate;
    private Date updateDate;
    private int hitCount;
    private int regMemberId;


    public Notice(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
}
