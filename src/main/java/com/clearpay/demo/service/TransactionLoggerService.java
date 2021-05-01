package com.clearpay.demo.service;

import com.clearpay.demo.entity.Transaction;
import com.clearpay.demo.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionLoggerService {
    private final TransactionRepository transactionRepository;

    public TransactionLoggerService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void registerTransaction(Transaction transactionEntity) {
        transactionRepository.save(transactionEntity);
    }


}
