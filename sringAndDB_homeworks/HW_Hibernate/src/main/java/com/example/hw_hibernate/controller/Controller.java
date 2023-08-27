package com.example.hw_hibernate.controller;

import com.example.hw_hibernate.repository.Person;
import com.example.hw_hibernate.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class Controller {
    @Autowired
    Repository repository;

    @GetMapping("/by-city")
    public List<Person> getCity(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }


}
