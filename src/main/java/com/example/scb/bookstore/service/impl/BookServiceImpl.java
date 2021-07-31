package com.example.scb.bookstore.service.impl;

import com.example.scb.bookstore.feign.client.BookClient;
import com.example.scb.bookstore.feign.model.Book;
import com.example.scb.bookstore.service.BookService;
import com.example.scb.bookstore.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl extends BaseService implements BookService {

    @Autowired
    protected BookClient bookClient;

    public List<Book> getBooks() {
        List<Book> books = bookClient.recommendation().stream().map(Book::setRecommended).collect(Collectors.toList());
        bookClient.books().stream().filter(it -> !books.contains(it)).forEach(books::add);
        return sortByRecommendedAndName(books);
    }

    @Override
    public List<Book> findAllById(List<Integer> ids) {
        return bookClient.books().stream().filter(book -> ids.contains(book.getId())).collect(Collectors.toList());
    }

    private List<Book> sortByRecommendedAndName(List<Book> books) {
        books.sort(Comparator.comparing(Book::isRecommended).reversed().thenComparing(Book::getBookName));
        return books;
    }
}
