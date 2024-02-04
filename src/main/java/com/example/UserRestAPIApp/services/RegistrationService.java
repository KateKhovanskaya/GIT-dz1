package com.example.UserRestAPIApp.services;

import com.example.UserRestAPIApp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService(){
        return dataProcessingService;
    }

    public User processRegistration(String name, int age, String email){
        User user =  userService.createUser(name, age, email);
        dataProcessingService.getRepository().getUsers().add(user);
        notificationService.sendNotification("A new user has been created: " + name);
        return user;
    }

    //Поля UserService, NotificationService
    // Метод processRegistration
}
