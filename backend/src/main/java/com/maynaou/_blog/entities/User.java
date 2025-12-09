package com.maynaou._blog.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
     @Id 
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String username;
     String email; 
     String profilePicture;
     LocalDateTime createdAt;
     LocalDateTime updateAt;
     boolean isActive; 
     String password;
     Role role;
}
