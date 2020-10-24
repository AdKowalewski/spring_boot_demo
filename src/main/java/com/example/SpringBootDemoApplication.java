package com.example;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
@Transactional
public class SpringBootDemoApplication implements CommandLineRunner {
    private UserService userService;

    public SpringBootDemoApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Find without address fetching...");
        User foundUser = userService.find(1L);
        System.out.println(foundUser);
        System.out.println("Find with address fetching...");
        System.out.println(userService.findWithAddresses(1L));

        foundUser.setFirstName("Janusz");
        foundUser.setLogin("jan.kowalski");
        System.out.println(userService.save(foundUser));

        System.out.println("End");
    }
}
