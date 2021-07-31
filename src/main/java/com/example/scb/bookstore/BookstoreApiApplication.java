package com.example.scb.bookstore;

import com.example.scb.bookstore.model.dao.User;
import com.example.scb.bookstore.repository.UserRepository;
import com.example.scb.bookstore.util.DateUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
//@EnableSwagger2
public class BookstoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApiApplication.class, args);
    }


    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            repository.save(new User("java.v", "123456", "Java", "Version", DateUtils.parseToDate("30/04/1991", DateUtils.DD_MM_YYYY)));
            repository.save(new User("john.doe", "thisismysecret", "john", "doe", DateUtils.parseToDate("15/01/1985", DateUtils.DD_MM_YYYY)));
        };
    }

}
