package com.weatherootd.wootd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
                        .requestMatchers("/wootds", "/wootds/login", "/wootds/loginProc", "/wootds/join", "/wootds/joinProcess", "/wootds/checkId", "/wootds/checkNick", "/wootds/map").permitAll()
                        .requestMatchers("/wootds/admin").hasRole("ADMIN")
                        .requestMatchers("/wootds/my/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                );

        http
                .formLogin((auth) -> auth.loginPage("/wootds/login")
                        .loginProcessingUrl("/wootds/main")
                        .permitAll()
                );

        http
                .csrf((auth) -> auth.disable());

        return http.build();
    }
}