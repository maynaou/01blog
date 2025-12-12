package com.maynaou._blog.security;

import org.springframework.security.core.userdetails.UserDetails;
import com.maynaou._blog.repository.UserRepository;
// import org.springframework.security.core.userdetails.User;
import com.maynaou._blog.entities.User;
public class UserDetailsServiceImpl  {
    
    private  UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) {
         User user = userRepository.findByUsername(username);
         if (user == null) {
             throw new RuntimeException("User not found");
         }

        //  UserDetails userDetails = User
            //  .password(user.getPassword())
            //  .roles(user.getRole().name())
            //  .build();
        //  return userDetails;
         return null;   
    }
}
