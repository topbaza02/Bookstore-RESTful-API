package com.example.scb.bookstore.service;

import com.example.scb.bookstore.model.dao.User;
import com.example.scb.bookstore.model.dto.req.OrderRequest;
import com.example.scb.bookstore.model.dto.res.OrderResponse;
import com.example.scb.bookstore.model.dto.res.UserDetailResponse;

import javax.servlet.http.HttpSession;

public interface UserService {

    User save(User user);

    void deleteUser(HttpSession session);

    OrderResponse orders(OrderRequest request, HttpSession session);

    User findByUsernameAndPassword(String username, String password);

    UserDetailResponse getUserDetail(HttpSession session);
}
