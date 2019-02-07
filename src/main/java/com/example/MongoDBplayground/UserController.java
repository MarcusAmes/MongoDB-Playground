package com.example.MongoDBplayground;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        List<User> users = this.userRepository.findAll();

        return users;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        this.userRepository.insert(user);
        return user;
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        this.userRepository.save(user);
        return user;
    }

    @DeleteMapping("/del/{id}")
    public void deleteUser(@PathVariable String id) {
        this.userRepository.deleteById(id);
    }
}
