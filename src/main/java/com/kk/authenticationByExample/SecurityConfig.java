package com.kk.authenticationByExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/oauth2/**", "/login/**").permitAll()
                        .requestMatchers("/").permitAll()
                        .anyRequest()
                        .fullyAuthenticated()
                )
                .formLogin(l -> l.defaultSuccessUrl("/private"))
                .httpBasic(Customizer.withDefaults())
                .oauth2Client(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults())
                // for form authentication .logout(l -> l.logoutSuccessUrl("/"))
                .logout(l->l.logoutSuccessUrl("http://localhost:9091/realms/externalauth/protocol/openid-connect/logout?redirect_uri=http://localhost:8080/"))
        ;
        return http.build();
    }
}
