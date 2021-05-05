package com.clearpay.demo;

import com.clearpay.demo.entity.Transaction;
import com.clearpay.demo.entity.Wallet;
import com.clearpay.demo.service.TransactionsService;
import com.clearpay.demo.service.WalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ClearpayDashboardApplicationTests {

    @Autowired
    TransactionsService transactionsService;
    @Autowired
    WalletService walletService;

    @Test
    void testTransactions() {
//        Transaction transaction = transactionsService.newTransactions();
//        String dow = transactionsService.newTransactions();
//        assertEquals(value1, value2 );

    }

    @Test
    void testWallet() {
        Wallet newWallet = walletService.addWallet(new Wallet("generatedID#randomNumber", new Date(), 80, "Account for test"));
        Wallet wallet = walletService.getWalletsByUserId("generatedID#randomNumber").get(0);
        assertEquals(newWallet.quantity, wallet.quantity);
        assertEquals(newWallet.alias, wallet.alias);
        //We can test transactions too, if sum and rest, etc
    }

    @Test
    void testUsers() {
        //More the same
    }

    @Test
    void contextLoads() {
    }


}
