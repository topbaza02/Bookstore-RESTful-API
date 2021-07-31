package com.example.scb.bookstore.service;

import com.example.scb.bookstore.model.dao.User;
import com.example.scb.bookstore.model.dto.req.LoginRequest;
import com.example.scb.bookstore.model.dto.req.OrderRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;


    private HttpSession session;

    @BeforeEach
    void initSession() {
        session = new MockHttpSession();
    }

    @Test
    @BeforeEach
    void save() {
        assertNotNull(userService.save(new User("test1", "pass1", "Unit1", "J1", new Date())));
    }

    @Test
    void orders() {
        loginService.login(new LoginRequest("test1", "pass1"), session);
        assertNotEquals(519, userService.orders(new OrderRequest(Arrays.asList(1, 2)), session));
    }

    @Test
    void findByUsernameAndPassword() {
        assertNotNull(userService.findByUsernameAndPassword("test1", "pass1"));
    }

    @Test
    void getUserDetail() {
        loginService.login(new LoginRequest("test1", "pass1"), session);
        assertNotNull(userService.getUserDetail(session));
    }


    @Test
    void deleteUser() {
        loginService.login(new LoginRequest("test1", "pass1"), session);
        userService.deleteUser(session);
        assertNull(userService.findByUsernameAndPassword("test1", "pass1"));
    }
}