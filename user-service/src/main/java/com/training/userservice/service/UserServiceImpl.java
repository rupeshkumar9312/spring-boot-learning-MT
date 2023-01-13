package com.training.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.training.userservice.Repository.UserRepository;
import com.training.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User addUser(User user) throws JsonProcessingException {
//        user.serializeAddressObj();
//        user.setAddress(user.getAddress());
        return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public List<User> saveAllUsers(List<User> users) {
        return repository.saveAll(users);
    }
}
