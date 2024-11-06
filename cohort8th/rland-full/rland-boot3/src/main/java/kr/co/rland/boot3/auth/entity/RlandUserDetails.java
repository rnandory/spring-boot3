package kr.co.rland.boot3.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RlandUserDetails implements UserDetails {

    private Long id;
    private String username; // * 필수
    private String password; // * 필수
    private String email;
    private Collection<? extends GrantedAuthority> authorities; // * 필수
}
