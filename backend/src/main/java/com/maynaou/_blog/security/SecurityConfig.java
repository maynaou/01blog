package com.maynaou._blog.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
public class SecurityConfig {

    private UserDetailsServiceImpl userDetailsServiceImpl;
    
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
          return http
        //   .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
        //   .exceptionHandling(eh->eh.accessDeniedPage("/notAuthorized"))
          .userDetailsService(userDetailsServiceImpl)
          .build();
    }
}
