package com.example.scb.bookstore.service.impl;

import com.example.scb.bookstore.constant.AppConstant;
import com.example.scb.bookstore.model.dao.User;
import com.example.scb.bookstore.model.dto.req.LoginRequest;
import com.example.scb.bookstore.service.LoginService;
import com.example.scb.bookstore.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
public class LoginServiceImpl extends BaseService implements LoginService {

    public boolean login(LoginRequest request, HttpSession session) {
        User user = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (!Objects.isNull(user)) {
            session.setAttribute(AppConstant.USER, user);
            session.setAttribute(AppConstant.IS_LOGGED_IN, true);
            return true;
        } else {
            logout(session);
            return false;
        }

    }

    public void logout(HttpSession session) {
        session.removeAttribute(AppConstant.USER);
        session.setAttribute(AppConstant.IS_LOGGED_IN, false);
    }
}
