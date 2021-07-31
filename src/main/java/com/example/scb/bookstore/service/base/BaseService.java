package com.example.scb.bookstore.service.base;

import com.example.scb.bookstore.service.BookService;
import com.example.scb.bookstore.service.LoginService;
import com.example.scb.bookstore.service.OrderService;
import com.example.scb.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseService {

    @Autowired
    protected BookService bookService;

    @Autowired
    protected LoginService loginService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected OrderService orderService;

}
