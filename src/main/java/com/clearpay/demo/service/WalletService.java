package com.clearpay.demo.service;

import com.clearpay.demo.entity.Transaction;
import com.clearpay.demo.entity.Wallet;
import com.clearpay.demo.models.TransactionRequest;
import com.clearpay.demo.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {
    private final WalletRepository repository;
    private final TransactionsService transactionsService;

    public WalletService(WalletRepository repository, TransactionsService transactionsService) {
        this.repository = repository;
        this.transactionsService = transactionsService;
    }

    public void transfer() {
    }

    private boolean checkBalance(Wallet wallet, int amount) {
        if (wallet != null) {
            return wallet.quantity > amount;
        }
        return false;
    }

    public Wallet getWalletById(String walletId) {
        Optional<Wallet> wallet = repository.findById(walletId);
        return wallet.orElse(null);
    }

    public List<Wallet> getAllWallets() {
        return repository.findAll();
    }

    public List<Wallet> getWalletsByUserId(String userId) {
        return repository.findAllByUserId(userId);
    }

    public int countAllByUserId(String userId) {
        return repository.countAllByUserId(userId);
    }

    public double getBalanceByUserId(String userId) {
        return repository.findAllByUserId(userId)
                .stream()
                .mapToLong(Wallet::getQuantity)
                .sum();
    }

    public Wallet addWallet(Wallet wallet) {
        return repository.save(wallet);
    }

    public List<Transaction> getWalletTransactionById(String walletId) {
        return transactionsService.getTransactionsByWalletId(walletId);
    }

    private void updateWallet(Wallet update) {
        repository.save(update);
    }

    public Transaction newTransactions(TransactionRequest transactionRequest) {
        Wallet tempWallet = this.getWalletById(transactionRequest.id);
        Wallet receivedWallet = this.getWalletById(transactionRequest.id);
        if (tempWallet != null) {
            if (checkBalance(tempWallet, transactionRequest.quantity)) {
                receivedWallet.quantity += transactionRequest.quantity;
                tempWallet.quantity -= transactionRequest.quantity;
                updateWallet(receivedWallet);
                return transactionsService.newTransactions(
                        transactionRequest.id,
                        transactionRequest.quantity,
                        transactionRequest.to);
            }
        }
        return null;
    }
}
