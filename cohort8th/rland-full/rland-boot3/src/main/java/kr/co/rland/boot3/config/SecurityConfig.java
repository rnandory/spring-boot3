package kr.co.rland.boot3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            CorsConfigurationSource corsConfigurationSource) throws Exception {

        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource)) // CorsConfigurationSource를 만들어서 ioc에 담아두면 알아서 씀
                .csrf(AbstractHttpConfigurer::disable) // 동일한 설정.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(authorizeRequests
                // 인터럽트 URL
                -> authorizeRequests
                    .requestMatchers("/admin/**").authenticated()
                    .anyRequest().permitAll());
        // 인증방식
//        http.formLogin(Customizer.withDefaults());
        http.formLogin(formConfig
                -> formConfig
                    .loginPage("/user/signin")
                    .loginProcessingUrl("/user/signin")// 로그인폼에서 보낸 post요청을 처리할 url
                    .successForwardUrl("/"));
//                .successHandler())
        // 인증에 사용할 사용자 데이터 제공 by UserDetailsService

        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.addAllowedHeader("*");
//        source.setAllowCredentials(true); // 나중에 jwt토큰용
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    //UserDetails -> UserDetailsService
    /*
    * 1. 메모리 유저
    * 2. JdBc 유저
    * 3. X.500 유저
    * */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("newlec")
                .password("{noop}111")
                .roles("MEMBER", "ADMIN")
                .build();

        UserDetails user2 = User.builder()
                .username("dragon")
                .password("{noop}111")
                .roles("MEMBER")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

}
