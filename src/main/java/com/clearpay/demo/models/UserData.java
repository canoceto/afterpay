package com.clearpay.demo.models;

public class UserData {
    public String id;
    public String firstName;
    public String lastName;
    public int wallet;
    public double balance;

    public UserData() {
    }

    public UserData(String id, String firstName, String lastName, int wallet, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = wallet;
        this.balance = balance;
    }
}
