package com.clearpay.demo.service;

import com.clearpay.demo.entity.Transaction;
import com.clearpay.demo.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionsService {
    private final TransactionRepository repository;

    public TransactionsService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction getTransactionsById(String transactionsId) {
        return repository.findById(transactionsId).orElse(null);
    }

    public List<Transaction> getTransactionsByWalletId(String walletId) {
        return repository.findAllByWalletId(walletId);
    }

    private Transaction addTransaction(Transaction transaction) {
        try {
            return repository.save(transaction);
        } catch (Exception e) {
            return null;
        }
    }

    public Transaction newTransactions(String userWalletId, int amount, String idWalletReceptor) {
        return addTransaction(new Transaction(userWalletId, "Top-up", amount, idWalletReceptor, new Date()));
    }
}
