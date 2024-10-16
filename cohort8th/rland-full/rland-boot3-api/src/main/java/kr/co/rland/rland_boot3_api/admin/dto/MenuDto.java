package kr.co.rland.rland_boot3_api.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDto {
    private Long id;
    private String korName;
    private String engName;
    private Integer price;
    private Instant regDate;

    private Long categoryId;
    private Long regMemberId;
}
