package com.ssafy.study.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration        // 이 클래스가 설정클래스로 등록하고, Spring Security를 활성화시키는 역할
@EnableWebSecurity    // @EnableWebSecurity 애너테이션은 Spring Security 기능 활성화를 위한 다양한 클래스들을 import
@RequiredArgsConstructor
@Profile("local") // Profile이 local인 경우에만 설정이 동작한다.
public class SecurityConfig {
    private final MyAuthenticationSuccessHandler oAuth2LoginSuccessHandler;
    private final CustomOAuth2UserService customOAuth2UserService;
    private final JwtAuthFilter jwtAuthFilter;
    private final MyAuthenticationFailureHandler oAuth2LoginFailureHandler;
    private final JwtExceptionFilter jwtExceptionFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable() // HTTP 기본 인증을 비활성화
                .cors().and() // CORS 활성화
                .csrf().disable() // CSRF 보호 기능 비활성화
                .formLogin().disable() // form 로그인 비활성화
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션관리 정책을 STATELESS(세션이 있으면 쓰지도 않고, 없으면 만들지도 않는다)
                .and()
                .authorizeRequests() // 요청에 대한 인증 설정
                .antMatchers("/token/**").permitAll() // 토큰 발급을 위한 경로는 모두 허용
                .anyRequest().authenticated() // 그 외의 모든 요청은 인증이 필요하다.
                .and()
                .oauth2Login() // OAuth2 로그인 설정시작
                .userInfoEndpoint().userService(customOAuth2UserService) // OAuth2 로그인시 사용자 정보를 가져오는 엔드포인트와 사용자 서비스를 설정
                .and()
                .failureHandler(oAuth2LoginFailureHandler) // OAuth2 로그인 실패시 처리할 핸들러를 지정해준다.
                .successHandler(oAuth2LoginSuccessHandler); // OAuth2 로그인 성공시 처리할 핸들러를 지정해준다.


        // JWT 인증 필터를 UsernamePasswordAuthenticationFilter 앞에 추가한다.
        return http
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtExceptionFilter, JwtAuthFilter.class)
                .build();
    }

}