package com.example.websevicesblogg.controllers;

import com.example.websevicesblogg.enteties.User;
import com.example.websevicesblogg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/newuser")
    public ResponseEntity<String> newUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok("New user created");
    }

}
