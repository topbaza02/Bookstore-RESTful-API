package com.example.scb.bookstore.repository;

import com.example.scb.bookstore.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsernameAndPassword(String username, String password);
}
