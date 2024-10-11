package kr.co.rland.rland_boot3_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@ToString
@Entity
@Table(name = "menu")
public class Menu {
    @Id
//    @Column(name = "id", nullable = false)
    private Long id;

//    @Column(name = "kor_name")
    private String korName;

//    @Column(name = "eng_name")
    private String engName;

//    @Column(name = "price", nullable = false)
    private Integer price;

    @ColumnDefault("current_timestamp()")
//    @Column(name = "reg_date", nullable = false)
    private Instant regDate;

    private Long categoryId;
    private Long regMemberId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "reg_member_id")
//    private Member regMember;

}