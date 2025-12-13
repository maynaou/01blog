package com.maynaou._blog.security;

import org.springframework.stereotype.Service;
import com.maynaou._blog.security.config.JwtProperties;
// import com.maynaou._blog.entities.Role;
// import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;


@Service
public class JwtTokenProvider {
     
    private final JwtProperties jwtProperties;
    private Key key;

    public JwtTokenProvider(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
        this.key = Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        //   Claims claims = Jwts.claims().setSubject(username);
          return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpirationMs()))
            .signWith(key)
            .compact();
    }
}
