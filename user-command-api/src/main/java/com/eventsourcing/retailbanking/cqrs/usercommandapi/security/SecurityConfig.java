package com.eventsourcing.retailbanking.cqrs.usercommandapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] WHITE_LIST_URLS = {"/api/v1/**"};

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                    .antMatchers(WHITE_LIST_URLS).authenticated()
                    .anyRequest().permitAll()
            )
            .csrf().disable();
//            .oauth2Login(oauth2Login -> oauth2Login
//                    .loginPage("/oauth2/authorization/api-client-oidc")
//            )
//            .oauth2Client(Customizer.withDefaults());

        return http.build();
    }
}
