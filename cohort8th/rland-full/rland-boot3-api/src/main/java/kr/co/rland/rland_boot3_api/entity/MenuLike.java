package kr.co.rland.rland_boot3_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "menu_like")
public class MenuLike {
    @EmbeddedId
    private MenuLikeId id;

    @ColumnDefault("current_timestamp()")
    @Column(name = "reg_date")
    private Instant regDate;

}