package com.selenium.practice.browser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AlertsFramesWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // =====================
        // 1. Handle Alerts
        // =====================
        driver.get("https://demoqa.com/alerts");

        // Click the alert button
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Clicked: " + alert.getText());
        alert.accept();

        // Timer Alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("timerAlertButton")).click();
        Alert timerAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert Clicked: " + timerAlert.getText());
        timerAlert.accept();

        // Confirm Alert
        driver.findElement(By.id("confirmButton")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirm Alert Clicked: " + confirmAlert.getText());
        confirmAlert.accept();
        String confirmResult = driver.findElement(By.id("confirmResult")).getText();
        System.out.println("Action selected: " + confirmResult);

        // Prompt Alert
        driver.findElement(By.id("promtButton")).click();
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt Alert Clicked: " + promptAlert.getText());
        promptAlert.sendKeys("Allen");
        promptAlert.accept();
        String promptResult = driver.findElement(By.id("promptResult")).getText();
        System.out.println("Prompt entered: " + promptResult);

        // =====================
        // 2. Handle Frames
        // =====================
        driver.get("https://demoqa.com/frames");

        // Switch to frame by ID
        driver.switchTo().frame("frame1");
        WebElement frameHeading = driver.findElement(By.id("sampleHeading"));
        System.out.println("Frame text: " + frameHeading.getText());

        // Switch back to main content
        driver.switchTo().defaultContent();

        // =====================
        // 3. Handle Windows/Tabs
        // =====================
        driver.get("https://demoqa.com/browser-windows");

        // Save parent window
        String parentWindow = driver.getWindowHandle();

        // Open a new tab
        driver.findElement(By.id("tabButton")).click();

        // Switch to new window
        Set<String> allWindows = driver.getWindowHandles(); //put all window handles in a Set
        for (String handle : allWindows) {
            if (!handle.equals(parentWindow)) { //if the handle is not the parent window, switch to the next tab
                driver.switchTo().window(handle);
                System.out.println("Child Tab Title: " + driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);

        // ---- New Window ----
        driver.findElement(By.id("windowButton")).click();
        allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(parentWindow)) {

                driver.switchTo().window(handle);
                System.out.println("New Window Title: " + driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Back to Parent Window: " + driver.getTitle());

    }
}
