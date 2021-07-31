package com.example.scb.bookstore.service.impl;

import com.example.scb.bookstore.model.dao.Order;
import com.example.scb.bookstore.repository.OrderRepository;
import com.example.scb.bookstore.service.OrderService;
import com.example.scb.bookstore.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl extends BaseService implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public void deleteById(String id) {
        orderRepo.deleteById(id);
    }

    @Override
    public Optional<Order> findById(String id) {
        return orderRepo.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepo.save(order);
    }
}
