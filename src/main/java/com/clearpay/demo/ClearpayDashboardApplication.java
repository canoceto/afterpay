package com.clearpay.demo;

import com.clearpay.demo.entity.Transaction;
import com.clearpay.demo.entity.UserClient;
import com.clearpay.demo.entity.Wallet;
import com.clearpay.demo.models.UserData;
import com.clearpay.demo.service.TransactionLoggerService;
import com.clearpay.demo.service.TransactionsService;
import com.clearpay.demo.service.UserClientService;
import com.clearpay.demo.service.WalletService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ClearpayDashboardApplication implements CommandLineRunner {

    private final UserClientService userClientService;
    private final WalletService walletService;
    private final TransactionsService transactionsService;

    public ClearpayDashboardApplication(UserClientService userClientService, WalletService walletService, TransactionsService transactionsService, TransactionLoggerService transactionLoggerService) {
        this.userClientService = userClientService;
        this.walletService = walletService;
        this.transactionsService = transactionsService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClearpayDashboardApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // Data saved for time reason, no CRUD implemented
        String user1Id = userClientService.addUser(new UserClient("Alice", "Smith"));
        walletService.addWallet(new Wallet(user1Id, new Date(), 250, "investment"));
        walletService.addWallet(new Wallet(user1Id, new Date(), 100, "saving"));
        String user2Id = userClientService.addUser(new UserClient("Carlos", "Anoceto"));
        walletService.addWallet(new Wallet(user2Id, new Date(), 850, "investment"));
        walletService.addWallet(new Wallet(user2Id, new Date(), 700, "saving"));
        walletService.addWallet(new Wallet(user2Id, new Date(), 2000, "saving to school"));
    }
}
