package com.example.scb.bookstore.controller;

import com.example.scb.bookstore.feign.model.Book;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @SneakyThrows
    @Test
    void books() {
        ResponseEntity<Book[]> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/books").toString(), Book[].class);
        assertNotNull(response.getBody());
//        assertEquals("Hello Controller", response.getBody());
    }
}