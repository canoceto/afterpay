package com.clearpay.demo.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id
    public String id;

    public String user;
    public String action;
    public String to;
    public double amount;
    public Date date;

    public Transaction(String user, String action, double amount, Date date) {
        this.user = user;
        this.action = action;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(String user, String action, double amount, String to, Date date) {
        this.user = user;
        this.action = action;
        this.amount = amount;
        this.to = to;
        this.date = date;
    }

    public Transaction() {
    }
}
