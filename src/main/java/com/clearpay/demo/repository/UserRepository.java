package com.clearpay.demo.repository;

import com.clearpay.demo.models.User;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    //    Comment entire file
//    FirebaseAuth auth;
//    Firestore databases;
//    Firestore adminDatabase;
//
//    public UserRepository(Firestore firebaseDatabase, FirebaseAuth auth) {
//        this.auth = auth;
//        this.adminDatabase = firebaseDatabase;
//    }
//
//    public User getById(String userId) throws FirebaseAuthException {
//        return toModel(this.auth.getUser(userId));
//    }
//
//    public User getByTokenId(String tokenId) throws FirebaseAuthException {
//        return getById(auth.verifyIdToken(tokenId).getUid());
//    }
//
//    private User toModel(UserRecord firebaseUser) {
//        return new User(firebaseUser.getUid(), "SUPER_ADMIN");
//    }

}
