package com.example.jwtproject;

import com.example.jwtproject.model.Role;
import com.example.jwtproject.model.User;
import com.example.jwtproject.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class    JwtProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtProjectApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.createRole(new Role(null, "ROLE_USER"));
            userService.createRole(new Role(null, "ROLE_ADMIN" ));

            userService.createUser(new User(null, "Sam", "sam", "password", new ArrayList<>()));
            userService.createUser(new User(null, "Gery", "gery", "password", new ArrayList<>()));

            userService.addRoleToUser("sam", "ROLE_ADMIN");
            userService.addRoleToUser("sam", "ROLE_USER");
            userService.addRoleToUser("gery", "ROLE_USER");

        };
    }

}
