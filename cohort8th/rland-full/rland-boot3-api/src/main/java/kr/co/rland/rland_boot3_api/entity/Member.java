package kr.co.rland.rland_boot3_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", length = 45)
    private String username;

    @Column(name = "pwd", length = 145)
    private String pwd;

    @Column(name = "email", length = 45)
    private String email;

    @ColumnDefault("current_timestamp()")
    @Column(name = "reg_date")
    private Instant regDate;

}