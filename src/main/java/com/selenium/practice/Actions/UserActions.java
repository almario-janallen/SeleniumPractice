package com.selenium.practice.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UserActions {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // =====================
        // 1. Mouse Hover using DemoQA
        // =====================
        driver.get("https://demoqa.com/menu");
        Actions actions = new Actions(driver);
        WebElement mainItem2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        WebElement subSubList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        WebElement subSubItem1 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));

        actions.moveToElement(mainItem2)
                .moveToElement(subSubList)
                .moveToElement(subSubItem1)
                .click()
                .perform();

        if(subSubItem1.isDisplayed()) {
            System.out.println("✅ Sub Sub Item 1 is visible after hover and click");
        } else {
            System.out.println("❌ Sub Sub Item 1 is NOT visible");
        }

        // =====================
        // 2. Drag and Drop Test using herokuapp
        // =====================

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(columnA, columnB).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String columnAText = columnA.getText();
        if (columnAText.equals("B")) {
            System.out.println("✅ Drag and drop successful. Column A now contains B.");
        } else {
            System.out.println("❌ Drag and drop failed. Column A still contains: " + columnAText);
        }
        driver.quit();
    }
}
