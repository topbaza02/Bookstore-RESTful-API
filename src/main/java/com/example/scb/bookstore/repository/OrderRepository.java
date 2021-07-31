package com.example.scb.bookstore.repository;

import com.example.scb.bookstore.model.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
