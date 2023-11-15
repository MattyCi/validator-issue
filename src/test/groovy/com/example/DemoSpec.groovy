package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification
import jakarta.inject.Inject

@MicronautTest
class DemoSpec extends Specification {

    @Inject
    @Client("/")
    HttpClient client

    def 'should register user'() {
        given: 'a valid registration request'
        final req = new UserRegistrationRequest("sgg-user", "test123", "test123")

        when:
        client.toBlocking().exchange(HttpRequest.POST("/" + apiVersion + "/users/register", req))

        then:
        final user = userService.getUserByUsername(req.getUsername())
        assert user != null
        assert user.getUsername() == req.getUsername()
    }


}
