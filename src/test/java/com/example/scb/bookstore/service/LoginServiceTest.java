package com.example.scb.bookstore.service;

import com.example.scb.bookstore.constant.AppConstant;
import com.example.scb.bookstore.model.dto.req.LoginRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    private HttpSession session;

    @BeforeEach
    void initSession() {
        session = new MockHttpSession();
    }

    @Test
    void login() {
        assertTrue(loginService.login(new LoginRequest("john.doe", "thisismysecret"), session));
        assertNotNull(session.getAttribute(AppConstant.USER));
    }

    @Test
    void logout() {
        loginService.logout(session);
        assertNull(session.getAttribute(AppConstant.USER));
    }
}