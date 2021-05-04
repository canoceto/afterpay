package com.clearpay.demo.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id
    public String id;
    public String walletId;
    public String idWalletReceptor;
    public String action;
    public double amount;
    public Date date;

    public Transaction() {
    }

    public Transaction(String userWalletId, String action, int amount, String idWalletReceptor, Date date) {
        this.walletId = userWalletId;
        this.idWalletReceptor = idWalletReceptor;

        this.action = action;
        this.amount = amount;
        this.date = date;
    }
}
