package com.example.scb.bookstore.constant;

import org.springframework.http.HttpMethod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppConstant {
    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String USER = "user";
    public static final Map<String, List<String>> authPathMap = new HashMap<>();


    static {
        List<String> users = Arrays.asList(HttpMethod.DELETE.name(), HttpMethod.GET.name());
        List<String> usersOrder = Arrays.asList(HttpMethod.POST.name());
        authPathMap.put("/users", users);
        authPathMap.put("/users/orders", usersOrder);
    }
}
