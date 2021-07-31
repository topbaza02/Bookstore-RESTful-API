package com.example.scb.bookstore.controller;

import com.example.scb.bookstore.model.dao.User;
import com.example.scb.bookstore.model.dto.SaveUserValidateResult;
import com.example.scb.bookstore.model.dto.req.OrderRequest;
import com.example.scb.bookstore.model.dto.res.OrderResponse;
import com.example.scb.bookstore.model.dto.res.UserDetailResponse;
import com.example.scb.bookstore.service.UserService;
import com.example.scb.bookstore.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private UserValidator userValidator;

    @GetMapping
    public UserDetailResponse userLoggedIn(HttpSession session) {
        return service.getUserDetail(session);
    }

    @PostMapping
    public Object save(@RequestBody User user, BindingResult bindingResult) {
        SaveUserValidateResult result = userValidator.validateSave(user, bindingResult);
        if (!result.isPass()) {
            return result;
        }
        return service.save(user);
    }

    @PostMapping(value = "/orders")
    public OrderResponse orders(@RequestBody OrderRequest request, HttpSession session) {
        return service.orders(request, session);
    }


    @DeleteMapping
    public void deleteLoggedInUser(HttpSession session) {
        service.deleteUser(session);
    }


}