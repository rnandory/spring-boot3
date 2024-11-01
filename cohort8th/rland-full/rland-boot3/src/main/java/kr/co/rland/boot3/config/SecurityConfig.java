package kr.co.rland.boot3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorizeRequests
                // 인터럽트 URL
                -> authorizeRequests
                .requestMatchers("/admin/**").authenticated()
                .anyRequest().permitAll());
        // 인증방식
        http.formLogin(Customizer.withDefaults());

        return http.build();
    }
}