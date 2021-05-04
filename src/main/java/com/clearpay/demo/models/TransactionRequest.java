package com.clearpay.demo.models;

public class TransactionRequest {
    public String id;
    public int quantity;
    public String to;

    public TransactionRequest() {
    }

    public TransactionRequest(String id, int quantity, String to) {
        this.id = id;
        this.quantity = quantity;
        this.to = to;
    }
}
