package com.maynaou._blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maynaou._blog.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
