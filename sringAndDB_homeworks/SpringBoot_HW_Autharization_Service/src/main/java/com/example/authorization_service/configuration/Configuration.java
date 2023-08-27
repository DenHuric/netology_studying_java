package com.example.authorization_service.configuration;

import com.example.authorization_service.repository.UserRepository;
import com.example.authorization_service.service.AuthorizationService;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public AuthorizationService AuthorizationService() {
        return new AuthorizationService();
    }
}
