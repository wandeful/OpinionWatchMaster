package com.xnyesf.opinion.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author CaoLiangBin
 * @date 2024年12月10日 22:09
 * @description 安全配置类
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        new AntPathRequestMatcher("/opinion/normal/**")
                ).permitAll()  // 允许访问 /public/ 下的所有接口
                .requestMatchers(
                        new AntPathRequestMatcher("/opinion/security/**")
                ).authenticated() // 需要认证的接口
                .and()
                .formLogin()
                .and()
                .httpBasic();
        return http.build();
    }
}
