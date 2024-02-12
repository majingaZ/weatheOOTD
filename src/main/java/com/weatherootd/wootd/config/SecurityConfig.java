package com.weatherootd.wootd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/wootds", "/wootds/login", "/wootds/loginProc", "/wootds/join", "/wootds/joinProcess", "/wootds/checkId", "/wootds/checkNick", "/wootds/main", "/wootds/list").permitAll()
                        .requestMatchers("/wootds/admin").hasRole("ADMIN")
                        .requestMatchers("/wootds/my/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                ); // 접근 권한 설정

        http
                .formLogin((auth) -> auth
                        .loginPage("/wootds/login")
                        .loginProcessingUrl("/wootds/loginProc")
                        .permitAll()
                        .successHandler(successHandler())
                ); // 로그인 성공 시 핸들러

        http
                .sessionManagement((auth) -> auth
                        .maximumSessions(1) // 동일 아이디 로그인 허용 수
                        .maxSessionsPreventsLogin(false)); // 로그인 허용 수 초과 시 세션 삭제 후 로그인

        http
                .sessionManagement((auth) -> auth
                        .sessionFixation().changeSessionId()); // 로그인 시 동일 세션 이용, id 변경
        http
                .csrf((auth) -> auth.disable());

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() { // 핸들러 설정
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setDefaultTargetUrl("/wootds/main");
        return handler;
    }

}