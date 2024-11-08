package kr.co.rland.rland_boot3_api.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            CorsConfigurationSource corsConfigurationSource) throws Exception {

        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource)) // CorsConfigurationSource를 만들어서 ioc에 담아두면 알아서 씀
                // 포스트하는 태그에 input hidden을 심어서 키값을 같이 보내도록 설정하면 되지만 귀찮아서..
                .csrf(AbstractHttpConfigurer::disable) // 동일한 설정.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(authorizeRequests
                        // 1. 인터렙트 URL
                        -> authorizeRequests
                        .requestMatchers("/admin/**").hasRole("ADMIN")/*.authenticated()*/
                        .requestMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER")
                        .requestMatchers("/post/**").authenticated()
                        .anyRequest().permitAll());

        // 2. 인증방식
        // 서버는 인증상태를 저장할 필요없음
        http
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // 3. 인증에 사용할 사용자 데이터 제공 by UserDetailsService

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
//    @Bean // 1. 메모리 유저
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

    // 2. JDBC를 이용한 사용자 목록을 이용할 때/
    /*
       1. 서비스 만들어서 넘겨줌
       2. 쿼리하도록 함
    */
//    @Bean
    public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {
        // sql query를 전달하는 방법
        // -> 스프링이 기대하는 결과집합
        /*
            username password enabled
        */
        String userSql = "select username, pwd password, 1 enabled from member where username=?";
        // -> 스프링이 기대하는 결과집합
        /*
            username authority
            newlec  ROLE_AMIN
        */
        String roleSql = "select username, 'ROLE_ADMIN' authority from member where username=?";


        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        // 위에서 di받아서 꺼내써도됨  @Autowired private DataSource dataSource; 하지만 그냥 매개변수에 넣으면 스프링이 알아서 해줌
        manager.setUsersByUsernameQuery(userSql);
        manager.setAuthoritiesByUsernameQuery(roleSql);

        return manager;
    }


}
