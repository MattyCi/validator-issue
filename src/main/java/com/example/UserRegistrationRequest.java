package com.example;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class UserRegistrationRequest {

    String username;
    String password;
    String passwordVerify;
}
