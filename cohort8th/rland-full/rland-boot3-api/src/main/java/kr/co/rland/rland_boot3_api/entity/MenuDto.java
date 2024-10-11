package kr.co.rland.rland_boot3_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "menu_dto")
public class MenuDto {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "default_image")
    private String defaultImage;

    @Column(name = "eng_name")
    private String engName;

    @Column(name = "kor_name")
    private String korName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "reg_date")
    private Instant regDate;

    @Column(name = "reg_member_id")
    private Long regMemberId;

}