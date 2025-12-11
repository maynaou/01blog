package com.maynaou._blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.maynaou._blog.dto.LoginRequest;
import com.maynaou._blog.dto.RegisterRequest;
import com.maynaou._blog.entities.User;
import com.maynaou._blog.repository.UserRepository;
import com.maynaou._blog.entities.Role;
import com.maynaou._blog.security.JwtTokenProvider;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

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

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setActive(true);
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    public void login(LoginRequest loginRequest) {
          User user = userRepository.findByUsername(loginRequest.getIdentifier());
          if (user == null) {
          user = userRepository.findByEmail(loginRequest.getIdentifier());
          }
          if (user == null) {
          throw new RuntimeException("User not found");
          }
          
          if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
          {
          throw new RuntimeException("Invalid password");
          }

          String token = jwtTokenProvider.generateToken(user.getUsername(),user.getRole());
          System.out.println("JWT Token: " + token);
          System.out.println("User logged in successfully");
    }
}
