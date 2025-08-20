package com.selenium.practice.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlazeJavaScriptExecutor {
    public static void main(String[] args) throws InterruptedException {
        // 1. Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        // 2. Initiate JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 3. Scroll down by pixels (to load more products)
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000); //wait for products to load

        // 4. Scroll to a specific product (Sony vaio i5)
        WebElement sonyVaio = driver.findElement(By.xpath("//a[text()='Sony vaio i5']"));
        js.executeScript("arguments[0].scrollIntoView(true)", sonyVaio);
        Thread.sleep(1000);

        // 5. Highlight the product (useful for demo)
        js.executeScript("arguments[0].style.border='3px solid red'", sonyVaio);
        Thread.sleep(2000);

        // 6. Click product using JavaScript
        js.executeScript("arguments[0].click()", sonyVaio);
        Thread.sleep(1000);

        // 7. Scroll to "Add to cart" button
        WebElement addToCartBtn = driver.findElement(By.xpath("//a[text()='Add to cart']"));
        js.executeScript("arguments[0].scrollIntoView(true)", addToCartBtn);
        Thread.sleep(1000);

        // 8. Highlight "Add to cart" button
        js.executeScript("arguments[0].style.border='3px solid red'", addToCartBtn);
        Thread.sleep(2000);

        // 9. Click "Add to Cart" using JavaScript
        js.executeScript("arguments[0].click()", addToCartBtn);

        // 10. Handle Alert after clicking Add to Cart
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        // 11. Navigate to cart to confirm
        WebElement cartLink = driver.findElement(By.xpath("//a[text()='Cart']"));
        js.executeScript("arguments[0].scrollIntoView(true)", cartLink);
        Thread.sleep(1000);

        // 12. Go to Cart Link using JavaScript
        js.executeScript("arguments[0].click()", cartLink);
        Thread.sleep(2000);

        // 13. Confirm if Added to cart
        WebElement sonyVaioAdded = driver.findElement(By.xpath("//td[text()='Sony vaio i5']"));
        js.executeScript("arguments[0].scrollIntoView(true)", sonyVaioAdded);
        js.executeScript("arguments[0].style.border='3px solid red'", sonyVaioAdded);
        Thread.sleep(2000);

        // 14. Print confirmation
        System.out.println("Product added using JSExecutor");

        // 15. Close browser
        driver.quit();
    }
}
