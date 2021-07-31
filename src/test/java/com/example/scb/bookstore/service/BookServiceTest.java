package com.example.scb.bookstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void getBooks() {
        assertNotNull(bookService.getBooks());
    }

    @Test
    void findAllById() {
        assertNotNull(bookService.findAllById(Arrays.asList(1, 2)));
    }
}