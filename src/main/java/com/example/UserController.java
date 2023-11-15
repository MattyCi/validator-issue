package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller
public class UserController {

    @Post("/user")
    public HttpResponse<String> helloUser(@Body @ValidUserRegistration UserRegistrationRequest userRegistrationRequest) {
        return HttpResponse.status(HttpStatus.OK).body("hello " + userRegistrationRequest.username + "! :)");
    }
}
