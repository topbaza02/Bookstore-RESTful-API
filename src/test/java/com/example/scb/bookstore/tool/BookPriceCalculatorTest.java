package com.example.scb.bookstore.tool;

import com.example.scb.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookPriceCalculatorTest {

    @Autowired
    private BookService bookService;

    @Test
    void sum() {
        assertEquals(519, new BookPriceCalculator(bookService.findAllById(Arrays.asList(1, 2))).sum());
    }
}