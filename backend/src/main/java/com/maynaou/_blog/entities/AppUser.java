package com.maynaou._blog.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
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
@Data
public class AppUser {
     @Id 
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String username;
     String email; 
     String profilePicture;
     @CreationTimestamp
     @Column(updatable = false)
     LocalDateTime createdAt;
     boolean isActive; 
     String password;
     @Enumerated(EnumType.STRING)
     Role role;

}
