package com.KushagraBhaskar.ToDo_App.Controller;

import com.KushagraBhaskar.ToDo_App.Entities.User;
import com.KushagraBhaskar.ToDo_App.Repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping
public class UserController {

    public final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    List<User> getUser(){
        return userRepository.findAll();
    }

    @PostMapping("/add-user")
    void setUser(){
    }
}
