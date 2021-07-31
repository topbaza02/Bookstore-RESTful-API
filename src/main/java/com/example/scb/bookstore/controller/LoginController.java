package com.example.scb.bookstore.controller;

import com.example.scb.bookstore.model.dto.req.LoginRequest;
import com.example.scb.bookstore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService service;

    @PostMapping
    public ResponseEntity login(@RequestBody LoginRequest request, HttpSession session) {
        if (service.login(request, session)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
