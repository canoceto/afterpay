package com.clearpay.demo.repository.interfaces;

import com.clearpay.demo.entity.TransactionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TransactionRepositoryInterface extends MongoRepository<TransactionEntity, String> {

}
