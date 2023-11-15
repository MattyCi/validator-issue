package com.example;

import jakarta.inject.Singleton;

@Singleton
public class SomeService {

    public void logUserName(String username) {
        System.out.println("HI THERE " + username);
    }

}
