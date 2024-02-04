package com.example.UserRestAPIApp.controllers;

import com.example.UserRestAPIApp.domain.User;
import com.example.UserRestAPIApp.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;
    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }
    @GetMapping("/sort")
    public List<User> sortUsersByAge(){
        return service.sortUserByAge(service.getRepository().getUsers());
    }
    // метод filterUsersByAge   @GetMapping("/filter/{age}")
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable ("age") int age){
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }
    // метод calculateAverageAge     @GetMapping("/calc")
    @GetMapping("/calc")
    public double calculateAverageAge(){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
