package com.example.scb.bookstore.tool;

import com.example.scb.bookstore.feign.model.Book;

import java.util.List;

public class BookPriceCalculator implements Calculator {

    private List<Book> books;

    public BookPriceCalculator(List<Book> books) {
        this.books = books;
    }

    public double sum() {
        return books.stream().map(Book::getPrice).reduce((double) 0, Double::sum);
    }

}


//
//
//interface Shape {
//    int area();
//}
//
//class Circle implements Shape {
//    public Circle(int i, int i1) {
//
//    }
//    // คำนวนพื้นที่ของ Circle
//    public int area() {
//        return 0;
//    }
//}
//
//class Rectangle implements Shape {
//    // คำนวนพื้นที่ของ Rectangle
//    public int area() {
//        return 0;
//    }
//}
//
//class AreaCalculator {
//    // คำนวนพื้นที่ของ Shape โดย call method "area"
//
//
//
//    public int calc(Shape shape) {
//        return shape.area();
//    }
//}