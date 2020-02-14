package com.task.selenium.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String firstAddress;
    private String secondAddress;
    private String city;
    private String state;
    private String postalCode;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
