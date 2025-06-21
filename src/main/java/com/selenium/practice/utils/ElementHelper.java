package com.selenium.practice.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementHelper {
    public static void checkElement(WebElement element, String label) {
        if (element != null && element.isDisplayed()) {
            System.out.println("✅ " + label + " is present and displayed.");
        } else {
            System.out.println("❌ " + label + " not found or not visible.");
        }
    }
}

