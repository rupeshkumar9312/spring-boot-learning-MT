package com.training.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.userservice.domain.User;

import java.util.List;

public interface UserService {

    User addUser(User user) throws JsonProcessingException;
    List<User> getAllUsers();
    List<User> saveAllUsers(List<User> users);
}
