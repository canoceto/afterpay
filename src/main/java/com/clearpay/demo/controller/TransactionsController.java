package com.clearpay.demo.controller;

import com.clearpay.demo.entity.Transaction;
import com.clearpay.demo.models.TransactionRequest;
import com.clearpay.demo.service.TransactionsService;
import com.clearpay.demo.service.WalletService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/transaction")
public class TransactionsController {
    private final TransactionsService transactionsService;
    private final WalletService walletService;

    public TransactionsController(TransactionsService transactionsService, WalletService walletService, WalletService walletService1) {
        this.transactionsService = transactionsService;
        this.walletService = walletService1;
    }

    @GetMapping(path = "/all")
    public List<Transaction> getAll() {
        return transactionsService.getAllTransactions();
    }

    @GetMapping(path = "/{transactionId}/")
    public Transaction getTransaction(@PathVariable String transactionId) {
        return transactionsService.getTransactionsById(transactionId);
    }

    @PostMapping(path = "/new")
    public Transaction newTransaction(@RequestBody TransactionRequest transactionRequest) {
//        return transactionsService.newTransactions(transactionRequest.id, transactionRequest.quantity, transactionRequest.to);
        return walletService.newTransactions(transactionRequest);
    }
}
