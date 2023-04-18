package com.stc.petlove.securities;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/**").permitAll() // Cho phép tất cả các yêu cầu truy cập vào API /api/public/**
                .anyRequest().authenticated() // Yêu cầu xác thực cho các yêu cầu khác
                .and()
                .csrf().disable() // Tắt bảo vệ CSRF
                .headers().frameOptions().disable(); // Tắt bảo vệ Clickjacking
    }
}

