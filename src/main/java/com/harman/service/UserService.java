package com.harman.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harman.entity.UserPojo;
import com.harman.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserPojo> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(UserPojo user) {
        userRepository.save(user);
    }

    public UserPojo getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}

