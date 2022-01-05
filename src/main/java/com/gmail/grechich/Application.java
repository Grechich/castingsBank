package com.gmail.grechich;

import com.gmail.grechich.security.CustomUser;
import com.gmail.grechich.security.UserRepository;
import com.gmail.grechich.security.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}