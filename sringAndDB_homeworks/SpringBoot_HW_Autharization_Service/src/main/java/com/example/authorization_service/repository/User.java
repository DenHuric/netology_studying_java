package com.example.authorization_service.repository;

import java.util.List;
import java.util.Objects;

public class User {
    private String user;
    private String password;
    private List<Authorities> authorities;

    public User(String user, String password, List<Authorities> authorities) {
        this.user = user;
        this.password = password;
        this.authorities = authorities;
    }

    public User(String user, String password){
        this.user = user;
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password, authorities);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(this.user, user.user) && Objects.equals(password, user.password);
    }

    @Override
    public String toString() {
        return "user: " + user + "\n password: " + password;
    }
}
