package com.example.scb.bookstore.service;

import com.example.scb.bookstore.model.dao.Order;

import java.util.Optional;

public interface OrderService {
    void deleteById(String id);

    Optional<Order> findById(String username);

    Order save(Order order);
}
