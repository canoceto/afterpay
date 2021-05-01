package com.clearpay.demo;

import com.clearpay.demo.entity.UserClient;
import com.clearpay.demo.entity.Wallet;
import com.clearpay.demo.service.TransactionLoggerService;
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
    private final TransactionLoggerService transactionLoggerService;

    public ClearpayDashboardApplication(UserClientService userClientService, WalletService walletService, TransactionLoggerService transactionLoggerService) {
        this.userClientService = userClientService;
        this.walletService = walletService;
        this.transactionLoggerService = transactionLoggerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClearpayDashboardApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        // save for test
        // repository.save(new UserClient("Alice", "Smith"));
        String userId = userClientService.addUser(new UserClient("Carlos", "Anoceto"));
        walletService.addWallet(new Wallet(userId, new Date(), 45, "Cuenta de Ahorro"));


        // fetch all Users
        System.out.println("Users found with findAll():");
        System.out.println("-------------------------------");
        for (UserClient customer : userClientService.getAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch all Waller
        System.out.println("Waller found with findAll():");
        System.out.println("-------------------------------");
        for (Wallet wallet : userClientService.getUserWalletById(userId)) {
            System.out.println(wallet);
        }

        // fetch all transaction
        System.out.println("transaction found with findAll():");
        System.out.println("-------------------------------");
        for (UserClient customer : userClientService.getAll()) {
            System.out.println(customer);
        }
    }

}
