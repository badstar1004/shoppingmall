package org.example.shoppingmall.commons.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.debug("SecurityConfig.configure.start");
        http
            .authorizeRequests()
                .antMatchers("/resources/**", "/", "/sign-in").permitAll() // 정적 리소스에 대한 접근 허용
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/sign-in")
            .and()
            .cors()
            .and()
            .csrf();
    }
}
