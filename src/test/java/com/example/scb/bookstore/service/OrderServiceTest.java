package com.example.scb.bookstore.service;

import com.example.scb.bookstore.model.dao.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    @BeforeEach
    void save() {
        assertNotNull(orderService.save(new Order("john.doe", "1,2")));
    }

    @Test
    void findById() {
        assertTrue(orderService.findById("john.doe").isPresent());
    }

    @Test
    void deleteById() {
        orderService.deleteById("john.doe");
        assertFalse(orderService.findById("john.doe").isPresent());
    }
}