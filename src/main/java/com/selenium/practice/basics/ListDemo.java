package com.selenium.practice.basics;

import java.util.ArrayList;

public class ListDemo {
    public static void main(String[] args) {

        /*ArrayList - dynamic size*/
        ArrayList<String> books = new ArrayList<>();

        // Add elements
        books.add("Atomic Habits");
        books.add("Mindset");
        books.add("Deep Work");

        // Access an element
        System.out.println("First book: " + books.get(0));

        // Remove an element
        books.remove("Mindset");

        // Loop through list
        for (String book : books) {
            System.out.println(book);
        }

        // Size of list
        System.out.println("Total books: " + books.size());

        /*Array - fixed size*/
        String[] fruits = new String[3];
        fruits[0] = "Apple";
        fruits[1] = "Banana";
        fruits[2] = "Orange";

        // Access an element
        System.out.println("First fruit: "+ fruits[1]);  // Banana

        // Loop through list
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Modifying elements
        fruits[0] = "Mango";

    }
}
