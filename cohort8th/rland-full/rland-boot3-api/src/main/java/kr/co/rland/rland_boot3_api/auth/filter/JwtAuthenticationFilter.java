package kr.co.rland.rland_boot3_api.auth.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.rland.rland_boot3_api.auth.entity.RlandUserDetails;
import kr.co.rland.rland_boot3_api.auth.util.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter/*Thread 처음 시작 시 한 번만 작동. redirect, fowarding.. 작동x*/ {

    private JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 토큰에 있는 내용을 모두 꺼내서 그것만으로 인증을 완성할건지?
        // 토큰에 있는 내용을 최소화하고 여기서 추가적인 인증을 완성할건지?

        String authHeader = request.getHeader("Authorization");

        /*
        if (authHeader == null || !authHeader.startsWith("Bearer "))
            filterChain.doFilter(request, response);
        이 방식은 맞지않음. return되지가 않음. 일단 다음 필터로 갔다가 다시 돌아와서 아래코드 실행
        */

        // 토큰을 가지고 있다면?
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            // 토큰 유효성 검사
            if (jwtUtil.validateToken(token)) {
                // 사용자 정보를 꺼내서
                /*
                db이용해서 userDetails
                    // userDetailsService를 쓰게되면 db에서 username으로 값을 꺼내는데 그게 싫으면 jwt에서 꺼내써도 됨
                    if (username != null && !username.isEmpty()) {
                        // 사용자 정보 + role데이터까지 로드.
                        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    }
                */
                String username = jwtUtil.extractUsername(token);
                List<String> roles = jwtUtil.extractRoles(token);

                // 인증정보를 담는다
                if (username != null && !username.isEmpty()) {
                    List<SimpleGrantedAuthority> authorities = new ArrayList<>();

                    for (String role : roles)
                        authorities.add(new SimpleGrantedAuthority(role));

                    RlandUserDetails userDetails = RlandUserDetails.builder()
//                            .id(member.getId())
                            .username(username)
//                            .password(member.getPwd())
//                            .email(member.getEmail())
                            .authorities(authorities)
                            .build();

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // 인증정보 외 기타 정보도 같이 담아줌
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }

        // 위쪽은 사전처리(인증정보를 가공해서 권한필터에게 전달. 권한필터가 인증정보로 권한을 체크)
        filterChain.doFilter(request, response); // -> 권한필터에게 전달
        // 다음은 사후처리
    }
}
