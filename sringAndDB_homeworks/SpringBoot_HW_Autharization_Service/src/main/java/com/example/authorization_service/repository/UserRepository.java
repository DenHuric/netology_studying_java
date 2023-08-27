package com.example.authorization_service.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    Map<String, User> userMap = new HashMap<>();

    public UserRepository() {
        userMap.put("test", new User("test", "qwe", List.of(Authorities.READ)));
        userMap.put("user", new User("user", "asd", List.of(Authorities.READ, Authorities.WRITE)));
        userMap.put("root", new User("root", "zxc", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
    }


    public List<Authorities> getUserAuthorities(String user, String password) {
        if (userMap.containsKey(user) && userMap.get(user).getPassword().equals(password)) {
            return userMap.get(user).getAuthorities();
        } else {
            return new ArrayList<>();
        }
    }
}
