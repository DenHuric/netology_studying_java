package com.example.hw_hibernate;

import com.example.hw_hibernate.repository.Person;
import com.example.hw_hibernate.repository.Repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HwHibernateApplication implements CommandLineRunner{
    @Autowired
    Repository repository;
    public static void main(String[] args) {
        SpringApplication.run(HwHibernateApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
       repository.generatePersons();
    }


}
