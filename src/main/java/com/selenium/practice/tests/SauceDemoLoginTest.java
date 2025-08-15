package com.selenium.practice.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoLoginTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            // ===== Positive Test =====
            System.out.println("=== Positive Test: Valid Login ===");
            login(driver, "standard_user", "secret_sauce", true);

            // ===== Negative Test =====
            System.out.println("\n=== Negative Test: Invalid Login ===");
            login(driver, "standard_user", "incorrect_password", false);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    /**
     * Login helper method
     *
     * @param driver        WebDriver instance
     * @param username      Username to enter
     * @param password      Password to enter
     * @param shouldSucceed True if expecting successful login, false for negative test
     */
    public static void login(WebDriver driver, String username, String password, boolean shouldSucceed) {
        // Navigate to login page
        driver.get("https://www.saucedemo.com/");
        System.out.println("Opening browser and navigating to SauceDemo");

        // Enter username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.clear();
        usernameField.sendKeys(username);
        System.out.println("Entering username: " + username);

        // Enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Entering password: " + password);

        // Click login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        System.out.println("Clicking login button");

        // Validation
        if (shouldSucceed) {
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("inventory.html")) {
                System.out.println("✅ Login successful — Products page is displayed");
            } else {
                System.out.println("❌ Login failed — Products page not displayed");
            }
        } else {
            WebElement errorMsg = driver.findElement(By.cssSelector("h3[data-test='error']"));
            String errorText = errorMsg.getText();
            if (errorText.contains("Username and password do not match")) {
                System.out.println("✅ Error message displayed: " + errorText);
            } else {
                System.out.println("❌ Expected error message not found");
            }
        }
    }
}
