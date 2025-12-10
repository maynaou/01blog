package com.maynaou._blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.maynaou._blog.entities.Role;
import com.maynaou._blog.entities.User;
import com.maynaou._blog.repository.UserRepository;
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    
	//@Bean
	CommandLineRunner start(UserRepository userRepository) {
		return args -> {
			User user = new User(null, "maynaou", "mohssin123@gmail.com","picture", null, null, true, "1234", Role.ADMIN);
			userRepository.save(user);
			userRepository.findAll().forEach(u -> {
				System.out.println(u.toString());
			});
		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
