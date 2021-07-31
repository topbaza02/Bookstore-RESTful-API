package com.example.scb.bookstore.interceptor;

import com.example.scb.bookstore.constant.AppConstant;
import com.example.scb.bookstore.model.dto.AuthMsg;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Component
@Log4j2
public class AuthInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        log.info("--preHandle--");
        AuthMsg authMsg = new AuthMsg();
        boolean result = true;

        if (AppConstant.authPathMap.containsKey(request.getRequestURI())) {
            List<String> methods = AppConstant.authPathMap.get(request.getRequestURI());
            if (methods.contains(request.getMethod())) {
                if (!isLoggedIn(request.getSession().getAttribute(AppConstant.IS_LOGGED_IN))) {
                    result = false;
                    authMsg.setMessage("Please login.");
                }
            }
        }
        if (!result) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(mapper.writeValueAsString(authMsg));
        }
        return result;
    }


    private boolean isLoggedIn(Object isLoggedIn) {
        return !Objects.isNull(isLoggedIn) && (Boolean) isLoggedIn;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        //
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        //
    }
}