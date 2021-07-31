package com.example.scb.bookstore.controller;

import com.example.scb.bookstore.model.dto.req.LoginRequest;
import lombok.SneakyThrows;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @SneakyThrows
    @Test
    void login_ok() throws JSONException {
        ResponseEntity response = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/login").toString(), new LoginRequest("john.doe", "thisismysecret"), ResponseEntity.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}