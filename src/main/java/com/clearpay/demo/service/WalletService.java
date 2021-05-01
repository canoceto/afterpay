package com.clearpay.demo.service;

import com.clearpay.demo.entity.Wallet;
import com.clearpay.demo.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {
    private final WalletRepository repository;

    public WalletService(WalletRepository repository) {
        this.repository = repository;
    }

    public void transfer() {
    }

    private boolean checkBalance() {
        return false;
    }

    public Wallet getWalletById(String walletId) {
        Optional<Wallet> wallet = repository.findById(walletId);
        return wallet.orElse(null);
    }

    public List<Wallet> getWalletsByUserId(String userId) {
        return repository.findAllByUserId(userId);
    }

    public Wallet addWallet(Wallet wallet) {
        return repository.save(wallet);
    }


}
