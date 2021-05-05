package com.clearpay.demo.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
class DataConfig {

    //Comment all @beans

    InputStream googleCredentialsAdmin = DataConfig.class.getResourceAsStream("/clearpay-faa65-firebase-adminsdk-tgq9j-cc3d855c56.json");

    @Bean
    public FirebaseApp firebaseAppAdmin() {
        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(googleCredentialsAdmin))
                    .setDatabaseUrl("https://clearpay-faa65.firebaseio.com")
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FirebaseApp.initializeApp(options);
    }

    @Bean
    public FirebaseAuth firebaseAuth(FirebaseApp firebaseAppAdmin) {
        return FirebaseAuth.getInstance(firebaseAppAdmin);
    }

    @Bean
    public Firestore firebaseDatabase(FirebaseApp firebaseAppAdmin) {
        return FirestoreClient.getFirestore(firebaseAppAdmin);
    }

}
