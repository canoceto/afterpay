package com.clearpay.demo.models;

public class User {
    String id;
    String role;
    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public User(String id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
