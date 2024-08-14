package com.kk.authenticationByExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/endpoint").hasAuthority("USER")
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
