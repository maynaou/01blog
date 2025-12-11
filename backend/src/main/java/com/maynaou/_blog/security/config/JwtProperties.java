package com.maynaou._blog.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
@Validated
public class JwtProperties {
    @NotBlank
    private String secretKey;
    @Positive
    private long expirationMs;
}
