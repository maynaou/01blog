package com.maynaou._blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maynaou._blog.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
     boolean existsByUsername(String username); 
     boolean existsByEmail(String email);
     AppUser findByUsername(String username);
     AppUser findByEmail(String email);
}
