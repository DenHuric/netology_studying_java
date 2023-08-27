package com.example.hw_spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/withAuth")
    public String withAuth() {
        return "Endpoint with Auth";
    }

    @GetMapping("/withAuth2")
    public String withAuth2() {
        return "Endpoint with Auth2";
    }

    @GetMapping("/withoutAuth")
    public String withoutAuth() {
        return "Endpoint without Auth";
    }
}
