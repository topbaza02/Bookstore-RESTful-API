package com.example.scb.bookstore.feign.client;

import com.example.scb.bookstore.feign.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bookClient", url = "https://scb-test-book-publisher.herokuapp.com/books")
public interface BookClient {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Book> books();

    @GetMapping(path = "/recommendation", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Book> recommendation();

//    @GetMapping(path = "/refresh_token?app_key={appKey}&app_secret={appSecret}&grant_type=refresh_token&refresh_token={refreshToken}", produces = MediaType.APPLICATION_JSON_VALUE)
//    TokenResponse refreshToken(@PathVariable String appKey, @PathVariable String appSecret, @PathVariable String refreshToken);

}
