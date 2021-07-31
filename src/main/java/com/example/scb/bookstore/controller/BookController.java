package com.example.scb.bookstore.controller;

import com.example.scb.bookstore.feign.model.Book;
import com.example.scb.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public List<Book> books() {
        return service.getBooks();
    }

}
