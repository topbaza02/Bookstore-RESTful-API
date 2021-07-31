package com.example.scb.bookstore.service;

import com.example.scb.bookstore.model.dto.req.LoginRequest;

import javax.servlet.http.HttpSession;

public interface LoginService {

    boolean login(LoginRequest request, HttpSession session);

    void logout(HttpSession session);
}
