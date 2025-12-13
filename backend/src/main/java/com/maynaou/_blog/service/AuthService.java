package com.maynaou._blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.maynaou._blog.dto.LoginRequest;
import com.maynaou._blog.dto.RegisterRequest;
import com.maynaou._blog.entities.AppUser;
import com.maynaou._blog.repository.UserRepository;
import com.maynaou._blog.entities.Role;
import com.maynaou._blog.security.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    private AuthenticationManager authenticationManager;

    // public void PasswordEncoder(PasswordEncoder passwordEncoder) {
    //     this.passwordEncoder = passwordEncoder;
    // }

    public void register(RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            throw new RuntimeException("Username already taken");
        }

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        AppUser user = new AppUser();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setActive(true);
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    public void login(LoginRequest loginRequest) {
          Authentication authenticationRequest = new UsernamePasswordAuthenticationToken(loginRequest.getIdentifier(), loginRequest.getPassword());
          Authentication authentication =   authenticationManager.authenticate(authenticationRequest);
          String token = jwtTokenProvider.generateToken(authentication.getName());
          System.out.println("JWT Token: " + token);
          System.out.println("User logged in successfully");
    }
}
