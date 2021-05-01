package com.clearpay.demo.service;

import com.clearpay.demo.entity.UserClient;
import com.clearpay.demo.entity.Wallet;
import com.clearpay.demo.repository.UserClientRepository;
import com.clearpay.demo.service.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserClientService implements UserServiceInterface {
    private final UserClientRepository userClientRepository;
    private final TransactionLoggerService transactionLoggerService;
    private final WalletService walletService;


    public UserClientService(UserClientRepository userClientRepository, TransactionLoggerService transactionLoggerService1, WalletService walletService) {
        this.userClientRepository = userClientRepository;
        this.transactionLoggerService = transactionLoggerService1;
        this.walletService = walletService;
    }

    @Override
    public List<UserClient> getAll() {
        return userClientRepository.findAll();
    }

    @Override
    public UserClient getUser(String id) {
        Optional<UserClient> userClient = userClientRepository.findByFirstName(id);
        return userClient.orElse(null);
    }

    @Override
    public UserClient getUserByName(String userName) {
        Optional<UserClient> userClient = userClientRepository.findByFirstName(userName);
        return userClient.orElse(null);
    }

    @Override
    public String addUser(UserClient userClient) {
        try {
            return userClientRepository.save(userClient).id;
        } catch (Exception e) {
            return "{ERROR:500}";
        }
//        return "{Status:200}";
    }

    @Override
    public List<Wallet> getUserWalletById(String userId) {
        return walletService.getWalletsByUserId(userId);
    }

}
