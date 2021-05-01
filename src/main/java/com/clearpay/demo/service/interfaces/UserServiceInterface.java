package com.clearpay.demo.service.interfaces;

import com.clearpay.demo.entity.UserClient;
import com.clearpay.demo.entity.Wallet;

import java.util.List;

public interface UserServiceInterface {

    List<UserClient> getAll();

    UserClient getUser(String id);

    UserClient getUserByName(String userName);

    String addUser(UserClient userClient);

    List<Wallet> getUserWalletById(String id);

}
