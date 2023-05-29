package com.ensa.demo.config;

import com.ensa.demo.model.Role;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**")
                .permitAll()
                .requestMatchers("/conductor/available*")
                .hasAnyRole(Role.MANAGER.name(),Role.ADMIN.name())
                .requestMatchers("/conductor/**")
                .hasAnyRole(Role.CONDUCTOR.name(),Role.ADMIN.name())
                .requestMatchers("/vehicule/available")
                .hasAnyRole(Role.MANAGER.name(),Role.ADMIN.name())
                .requestMatchers("/vehicule/**")
                .hasAnyRole(Role.ADMIN.name())
                .requestMatchers("/voyage/**")
                .hasAnyRole(Role.MANAGER.name(),Role.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter , UsernamePasswordAuthenticationFilter.class) ;
              return http.build();

    } 
}
