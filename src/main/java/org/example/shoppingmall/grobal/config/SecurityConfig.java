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
                .antMatchers("/resources/**", "/", "/auth/**", "/consumer/sign/**").permitAll() // 정적 리소스에 대한 접근 허용
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/auth/sign-in")
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
