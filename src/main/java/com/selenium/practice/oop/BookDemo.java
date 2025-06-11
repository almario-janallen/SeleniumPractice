package com.selenium.practice.oop;

public class BookDemo {
    public static void main(String[] args) {
        Book book1 = new Book("Mindset","Carol Dweck",23.50);
        Book book2 = new Book("Grit","Angela Duckworth",20.00);

        book1.applyDiscount(0.5);
        book1.DisplayInfo();
        System.out.println();
        book2.DisplayInfo();
    }
}
