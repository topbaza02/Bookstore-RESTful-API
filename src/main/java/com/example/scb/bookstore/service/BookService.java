package com.example.scb.bookstore.service;

import com.example.scb.bookstore.feign.model.Book;

import java.util.List;


public interface BookService {

    List<Book> getBooks();

    List<Book> findAllById(List<Integer> ids);
}
