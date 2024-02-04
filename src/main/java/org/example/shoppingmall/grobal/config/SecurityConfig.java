package org.example.shoppingmall.grobal.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@Configuration
@EnableWebMvc
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.debug("SecurityConfig.configure.start");
        http
            .authorizeRequests()
                .antMatchers("/resources/**").permitAll() // 정적 리소스에 대한 접근 허용
//                .antMatchers("/orders/**", "/baskets/**").authenticated() // /orders와 /baskets는 인증된 사용자만 접근 가능
                .anyRequest().permitAll() // 나머지 경로는 모두 접근 가능
//            .and()
//            .formLogin()
//                .loginPage("/auth/sign-in") // 사용자 정의 로그인 페이지 설정
//                .defaultSuccessUrl("/", true) // 로그인 성공 시 리디렉션할 기본 URL 설정
//                .permitAll() // 로그인 페이지 접근을 모두에게 허용
//            .and()
//            .logout()
//                .permitAll() // 로그아웃 접근을 모두에게 허용
            .and()
            .cors()
            .and()
            .csrf().disable();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
