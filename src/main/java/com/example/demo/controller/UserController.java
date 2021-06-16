package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserByID(@PathVariable Integer id){

        return userService.getUserById(id);
    }
}
