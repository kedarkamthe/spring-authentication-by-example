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
                        .requestMatchers("/").permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(l -> l.defaultSuccessUrl("/private"))
                .logout(l -> l.logoutSuccessUrl("/"));
        return http.build();
    }
}
