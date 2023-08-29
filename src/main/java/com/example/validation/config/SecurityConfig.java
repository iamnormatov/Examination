package com.example.validation.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;

    @Autowired
    public void authenticationManagerBuilder(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication()
//                .usersByUsernameQuery("select username from lessons where username = ?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }


//    @Autowired
//    public void authenticationManagerBuilder(AuthenticationManagerBuilder builder) throws Exception {
//         builder.inMemoryAuthentication()
//                .withUser("John")
//                .password(passwordEncoder.encode("doe"))
//                .roles("User")
//                .and()
//                .passwordEncoder(passwordEncoder);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable()
                .cors().disable()
                .authorizeHttpRequests()
                .requestMatchers("/lessons/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().build();
    }
}
