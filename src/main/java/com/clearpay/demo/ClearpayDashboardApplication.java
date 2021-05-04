package com.clearpay.demo;

import com.clearpay.demo.entity.Transaction;
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
    private final TransactionLoggerService transactionLoggerService;

    public ClearpayDashboardApplication(UserClientService userClientService, WalletService walletService, TransactionsService transactionsService, TransactionLoggerService transactionLoggerService) {
        this.userClientService = userClientService;
        this.walletService = walletService;
        this.transactionsService = transactionsService;
        this.transactionLoggerService = transactionLoggerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClearpayDashboardApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        // save for test
        // repository.save(new UserClient("Alice", "Smith"));
//        String userId = userClientService.addUser(new UserClient("Carlos", "Anoceto"));
//        transactionsService.addTransaction(new Transaction("userId", "Top-up", 45, "IdUsuarioReceptor", new Date(), "id Cuenta de Ahorro"));
//

        // fetch all Users
        System.out.println("Users found with findAll():");
        System.out.println("-------------------------------");
        for (UserData customer : userClientService.getAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch all Waller
        System.out.println("Waller found with findAll():");
        System.out.println("-------------------------------");
        for (Wallet wallet : userClientService.getUserWalletById("608c8433a666b665cc7bb9b8")) {
            System.out.println(wallet);
        }

        // fetch all transaction
        System.out.println("transaction found with findAll():");
        System.out.println("-------------------------------");
        for (UserData customer : userClientService.getAll()) {
            System.out.println(customer);
        }
    }

}
