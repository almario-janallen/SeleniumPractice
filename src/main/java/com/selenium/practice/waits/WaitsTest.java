package com.selenium.practice.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class WaitsTest {
    public static void main(String[] args) {
        // 🔧 Setup
        WebDriver driver = new ChromeDriver();

        try {
            // 🌐 Navigate to sample login page
            driver.get("http://www.saucedemo.com");

            // ⏱ 1. Implicit Wait (set globally)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement username = driver.findElement(By.cssSelector("input[name='user-name']"));
            WebElement password = driver.findElement(By.cssSelector("input[name='password']"));

            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");

            // ⏱ 2. Explicit Wait for clickable login button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            loginBtn.click();

            // ⏱ 3. FluentWait for welcome message or dashboard element
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver) // Create fluentWait object tied to driver instance
                    .withTimeout(Duration.ofSeconds(20)) // How long will I wait
                    .pollingEvery(Duration.ofSeconds(2)) // Check every 2 seconds if the condition is now true
                    .ignoring(NoSuchElementException.class); // While waiting, ignore the exception error

            WebElement inventoryContainer = fluentWait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    WebElement inventory = driver.findElement(By.cssSelector("div.inventory_list"));
                    return inventory.isDisplayed() ? inventory : null;
                }
            });

            // ✅ Output result
            System.out.println("Login successful. Inventory page is visible.");

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
            driver.quit(); // Clean up
        }
    }
}
