package com.training.userservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.userservice.domain.User;
import com.training.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
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

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Integer userId){
        userService.deleteUserById(userId);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userService.getUserByUserId(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable Integer userId){
        return userService.updateUserById(userId,user);
    }
}
