package com.example.hw_jdbc_dao.controller;

import com.example.hw_jdbc_dao.repository.Repository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/getProductByName")
    public List<String> getAuthorities(@RequestParam(name = "name") String name, HttpServletResponse response) {
        return repository.getProductName(name);
    }

}
