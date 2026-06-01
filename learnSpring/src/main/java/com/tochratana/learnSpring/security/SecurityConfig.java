package com.tochratana.learnSpring.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity httpSecurity){
        // TODO: defined your security configuration
        // 1. Security Mechanism -> HTTP Basic Authentication(Username and Password), now change to oauth2 server
        // httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));


        // httpSecurity.formLogin(Customizer.withDefaults());

        // 2. Session Stateless
        httpSecurity.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // 3. Endpoint Security
        httpSecurity.authorizeHttpRequests(
                endpoint ->
                        endpoint
//                                .requestMatchers("/api/v1/products/**").permitAll()

                                .anyRequest().authenticated() // for permitAll() is like public

        );

        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.formLogin(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }




}
