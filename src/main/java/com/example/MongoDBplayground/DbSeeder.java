package com.example.MongoDBplayground;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private UserRepository userRepository;

    public DbSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User marcus = new User(
                "marcus@gmail.com",
                "12345",
                "Marcus",
                "Ames",
                "432 N View");
        User oscar = new User(
                "oscar@gmail.com",
                "12345",
                "Oscar",
                "Sandoval",
                "134 W Dr");
        User harrsion = new User(
                "harrsion@gmail.com",
                "12345",
                "Harrison",
                "Van Nort",
                "924 E Way");

        //Drops all
        this.userRepository.deleteAll();

        //Add Users
        List<User> users = Arrays.asList(marcus, oscar, harrsion);
        this.userRepository.saveAll(users);
    }
}
