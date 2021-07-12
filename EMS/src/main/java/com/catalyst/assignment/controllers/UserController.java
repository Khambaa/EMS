package com.catalyst.assignment.controllers;

import com.catalyst.assignment.entities.User;
import com.catalyst.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registerUser")
    User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @DeleteMapping("/unregisterUser")
    void unRegisterUser(@RequestBody User user){
        userService.unRegisterUser(user);
    }
}
