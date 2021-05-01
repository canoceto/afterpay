package com.clearpay.demo.repository;

import com.clearpay.demo.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findAllByUser(String userName);

    Optional<Transaction> findById(String id);

}
