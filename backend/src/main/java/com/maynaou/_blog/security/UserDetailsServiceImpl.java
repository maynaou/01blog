package com.maynaou._blog.security;

import org.springframework.security.core.userdetails.UserDetails;
import com.maynaou._blog.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import com.maynaou._blog.entities.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private  UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
         AppUser user = userRepository.findByUsername(username);
         if (user == null) {
             throw new RuntimeException("User not found");
         }
         UserDetails userDetails = User
             .withUsername(user.getUsername())
             .password(user.getPassword())
             .roles(user.getRole().name())
             .build();
         return userDetails;
    }
}
