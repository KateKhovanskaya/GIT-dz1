package com.example.UserRestAPIApp.controllers;

import com.example.UserRestAPIApp.domain.User;
import com.example.UserRestAPIApp.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList(){
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }
}
