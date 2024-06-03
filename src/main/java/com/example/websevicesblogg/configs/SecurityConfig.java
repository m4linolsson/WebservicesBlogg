package com.example.websevicesblogg.configs;

import com.example.websevicesblogg.converters.JwtAuthConverter;
import jakarta.servlet.DispatcherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthConverter jwtAuthConverter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http.csrf(csrf -> csrf.disable());


        http
                .authorizeHttpRequests((auth) ->
                        auth
                                .dispatcherTypeMatchers( DispatcherType.ERROR).permitAll()
                                .requestMatchers("/api/posts/**", "/api/newuser").permitAll()
                                .requestMatchers("/api/users/**").hasRole("blogg_admin")
                                .anyRequest().authenticated()
                );

        http
                .oauth2ResourceServer(ors -> ors.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter)));

        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/newuser"));

//        http
//                .oauth2ResourceServer(ors -> ors.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter)));
//
//        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
