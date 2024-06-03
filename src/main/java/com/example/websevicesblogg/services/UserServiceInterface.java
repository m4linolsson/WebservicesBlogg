package com.example.websevicesblogg.services;


import com.example.websevicesblogg.enteties.User;

import java.util.List;

public interface UserServiceInterface {

    void createUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);
}
