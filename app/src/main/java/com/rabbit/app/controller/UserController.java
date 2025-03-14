package com.rabbit.app.controller;

import com.rabbit.app.repository.UserRepository;
import com.rabbit.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.rabbit.app.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService){
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public List<User> show(){
        return userRepository.findAll();
    }

    @PostMapping
    public boolean create(@RequestBody User data){
        return userService.registerUser(data.getName(), data.getEmail(), data.getPassword());
    }
}
