package com.selenium.practice.utils;

import org.openqa.selenium.WebDriver;

public class PageFunctions {
    public static void openPage(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void quitPage(WebDriver driver) {
        driver.quit();
    }
}
