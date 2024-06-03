package com.example.websevicesblogg.services;

import com.example.websevicesblogg.enteties.User;
import com.example.websevicesblogg.exceptions.ResourceNotFoundException;
import com.example.websevicesblogg.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {


    @Autowired
    UserRepository userRepository;


    @Override
    public void createUser(User user) {
        if (!userRepository.existsByUserName(user.getUserName())) {
            userRepository.save(user);
        } else throw new RuntimeException("User with username: " + user.getUserName() + " already exist");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
}
