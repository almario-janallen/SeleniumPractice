package com.selenium.practice.qa;


//Applies inheritance for exception
public class InvalidStatusException extends Exception {
    public InvalidStatusException(String message) {
        super(message);
    }
}
