package com.example.scb.bookstore.service.impl;

import com.example.scb.bookstore.constant.AppConstant;
import com.example.scb.bookstore.feign.model.Book;
import com.example.scb.bookstore.model.dao.Order;
import com.example.scb.bookstore.model.dao.User;
import com.example.scb.bookstore.model.dto.req.OrderRequest;
import com.example.scb.bookstore.model.dto.res.OrderResponse;
import com.example.scb.bookstore.model.dto.res.UserDetailResponse;
import com.example.scb.bookstore.repository.UserRepository;
import com.example.scb.bookstore.service.UserService;
import com.example.scb.bookstore.service.base.BaseService;
import com.example.scb.bookstore.tool.BookPriceCalculator;
import com.example.scb.bookstore.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserRepository userRepo;

    public User save(User user) {
        return userRepo.save(user);
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public UserDetailResponse getUserDetail(HttpSession session) {
        UserDetailResponse response = new UserDetailResponse();
        User user = getUserLoggedIn(session);
        Order order = orderService.findById(user.getUsername()).orElse(null);
        response.setName(user.getName());
        response.setSurname(user.getSurname());
        response.setDateOfBirth(DateUtils.format(user.getDateOfBirth(), DateUtils.DD_MM_YYYY));
        if (!Objects.isNull(order)) {
            response.setBooks(getOrderBooks(order));
        }
        return response;
    }

    public void deleteUser(HttpSession session) {
        User user = (User) session.getAttribute(AppConstant.USER);
        userRepo.delete(user);
        orderService.deleteById(user.getUsername());
        loginService.logout(session);
    }

    public OrderResponse orders(OrderRequest request, HttpSession session) {
        List<Book> books = bookService.findAllById(request.getOrders());
        if (CollectionUtils.isEmpty(books)) {
            return new OrderResponse(0d);
        } else {
            double price = new BookPriceCalculator(books).sum();
            saveOrder(session, books);
            return new OrderResponse(price);
        }
    }

    private void saveOrder(HttpSession session, List<Book> books) {
        User user = getUserLoggedIn(session);
        Order order = orderService.findById(user.getUsername()).orElse(new Order());

        List<Integer> bookIds = getOrderBooks(order);
        bookIds.addAll(books.stream().map(Book::getId).collect(Collectors.toList()));

        order.setUsername(user.getUsername());
        order.setBookId(bookIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        orderService.save(order);
    }

    private List<Integer> getOrderBooks(Order order) {
        List<Integer> bookIds = new ArrayList<>();
        if (StringUtils.isNotBlank(order.getBookId()))
            bookIds = Arrays.stream(order.getBookId().split(",")).map(Integer::valueOf).collect(Collectors.toList());

        return bookIds;
    }

    private User getUserLoggedIn(HttpSession session) {
        return (User) session.getAttribute(AppConstant.USER);
    }
}