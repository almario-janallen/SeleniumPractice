package com.selenium.practice.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginInteractionTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        // Username input
        WebElement username = driver.findElement(By.id("user-name"));
        username.clear();
        username.sendKeys("standard_user");

        // Password input
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("secret_sauce");

        // Login button
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        if (loginBtn.isDisplayed()) {
            loginBtn.click();
        }
    }
}
