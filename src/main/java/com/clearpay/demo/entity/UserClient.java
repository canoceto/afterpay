package com.clearpay.demo.entity;

import org.springframework.data.annotation.Id;

public class UserClient {
    @Id
    public String id;
    public String firstName;
    public String lastName;

    public UserClient() {
    }

    public UserClient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
