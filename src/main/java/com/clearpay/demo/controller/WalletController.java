package com.clearpay.demo.controller;

import com.clearpay.demo.entity.Wallet;
import com.clearpay.demo.service.WalletService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/wallet")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping(path = "/{walletId}")
    public Wallet getWallet(@PathVariable String walletId) {
        return walletService.getWalletById(walletId);
    }
}
