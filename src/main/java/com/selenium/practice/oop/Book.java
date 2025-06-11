package com.selenium.practice.oop;

public class Book {
    //Properties
    String title;
    String author;
    double price;
    double discountedPrice;

    public Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
        this.discountedPrice = price;
    }

    public void DisplayInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public void applyDiscount(double percent){
        this.discountedPrice = this.price * (1-percent);
    }
}
