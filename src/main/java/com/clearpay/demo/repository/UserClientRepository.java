package com.clearpay.demo.repository;

import com.clearpay.demo.entity.UserClient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserClientRepository extends MongoRepository<UserClient, String> {

    Optional<UserClient> findByFirstName(String firstName);

    List<UserClient> findByLastName(String lastName);

    Optional<UserClient> findById(String firstName);

}
