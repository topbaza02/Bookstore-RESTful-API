package com.example.scb.bookstore.feign.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@EqualsAndHashCode(exclude = {"isRecommended"})
public class Book {
    private String bookName;
    private double price;
    private Integer id;
    private String authorName;
    private boolean isRecommended;

    public Book setRecommended() {
        this.isRecommended = true;
        return this;
    }
}
