package com.example.authorization_service.controller;

import com.example.authorization_service.repository.Authorities;
import com.example.authorization_service.repository.User;
import com.example.authorization_service.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    @Autowired
    AuthorizationService service;


    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestBody User user) {
        return service.getAuthorities(user.getUser(),
                user.getPassword());
    }
}