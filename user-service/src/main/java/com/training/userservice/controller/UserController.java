package com.training.userservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.userservice.domain.User;
import com.training.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public User addUser(@RequestBody User user) throws JsonProcessingException {
//        System.out.println("");
        return  userService.addUser(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/all")
    public List<User> addAllUsers(@RequestBody List<User> users){
        return userService.saveAllUsers(users);
    }
}
