package com.clearpay.demo.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Wallet {
    @Id
    public String id;
    public String userId;
    public Date createdDate;
    public int quantity;
    public String alias;

    public Wallet(String userId, Date createdDate, int quantity, String alias) {
        this.userId = userId;
        this.createdDate = createdDate;
        this.quantity = quantity;
        this.alias = alias;
    }

    public Wallet() {
    }

    @Override
    public String toString() {
        return String.format(
                "Wallet[id=%s, userId='%s', quantity='%s' , alias='%s']",
                id, userId, quantity, alias);
    }
}
