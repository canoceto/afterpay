package com.clearpay.demo.service;

import com.clearpay.demo.models.User;
import com.clearpay.demo.repository.UserRepository;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User getByTokenId(String tokenId) throws FirebaseAuthException {
        return this.userRepository.getByTokenId(tokenId);
    }
}
