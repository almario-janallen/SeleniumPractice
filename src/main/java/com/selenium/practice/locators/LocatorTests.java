package com.selenium.practice.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorTests {
    public static void main(String[] args) {
        // Setup WebDriver (Make sure chromedriver path is correct)
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open test page (You can replace this with any test page you want)
        driver.get("https://www.saucedemo.com/");

        // Locate elements using different types of locators
        WebElement usernameField = driver.findElement(By.id("user-name"));           // ID
        WebElement passwordField = driver.findElement(By.name("password"));         // Name
        WebElement loginButton = driver.findElement(By.className("submit-button")); // Class Name
        WebElement loginForm = driver.findElement(By.tagName("form"));              // Tag Name

        // Interact with elements
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Optional: close browser
        driver.quit();
    }
}
