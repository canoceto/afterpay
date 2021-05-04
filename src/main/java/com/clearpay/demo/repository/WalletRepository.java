package com.clearpay.demo.repository;

import com.clearpay.demo.entity.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WalletRepository extends MongoRepository<Wallet, String> {
    List<Wallet> findAllByUserId(String userId);

    int countAllByUserId(String userId);

}
