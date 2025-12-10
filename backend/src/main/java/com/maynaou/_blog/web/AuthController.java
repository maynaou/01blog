package com.maynaou._blog.web;

import org.springframework.web.bind.annotation.RestController;

import com.maynaou._blog.dto.LoginRequest;
import com.maynaou._blog.dto.RegisterRequest;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.maynaou._blog.service.AuthService;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    
    @PostMapping("api/register")
    public String registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
         System.out.println(registerRequest.getUsername());
         System.out.println(registerRequest.getEmail());
         System.out.println(registerRequest.getPassword());   
         authService.register(registerRequest);
         return "User registered successfully";
    }

    @PostMapping("api/login")
    public String loginUser(@RequestBody  LoginRequest loginRequest) {
         System.out.println(loginRequest.getUsername());
         System.out.println(loginRequest.getEmail());
         System.out.println(loginRequest.getPassword());   
         authService.login(loginRequest);
        return "User logged in successfully";
    }
    
}
