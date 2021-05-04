package com.clearpay.demo.controller;


import com.clearpay.demo.entity.UserClient;
import com.clearpay.demo.entity.Wallet;
import com.clearpay.demo.models.UserData;
import com.clearpay.demo.service.UserClientService;
import com.clearpay.demo.service.interfaces.UserServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserServiceInterface userClientService;

    public UserController(UserClientService userClientService) {
        this.userClientService = userClientService;
    }

    @GetMapping(path = "/all")
    public List<UserData> getAllUser() {
        return userClientService.getAll();
    }

    @GetMapping(path = "/{id}")
    public UserClient getUserById(@PathVariable String id) {
        return userClientService.getUser(id);
    }

    @GetMapping(path = "/{name}")
    public UserClient getUserByName(@PathVariable String name) {
        return userClientService.getUserByName(name);
    }

    @GetMapping(path = "/{id}/wallets")
    public List<Wallet> getUserWallets(@PathVariable String id) {
        return userClientService.getUserWalletById(id);
    }

    @PostMapping(path = "/add")
    public String addUser(@RequestBody UserClient userClient) {
        return userClientService.addUser(userClient);
    }

}
