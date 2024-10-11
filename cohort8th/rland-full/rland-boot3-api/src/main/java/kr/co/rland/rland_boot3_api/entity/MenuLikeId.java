package kr.co.rland.rland_boot3_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class MenuLikeId implements java.io.Serializable {
    private static final long serialVersionUID = 4429695169366246171L;
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "menu_id", nullable = false)
    private Long menuId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MenuLikeId entity = (MenuLikeId) o;
        return Objects.equals(this.menuId, entity.menuId) &&
                Objects.equals(this.memberId, entity.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, memberId);
    }

}