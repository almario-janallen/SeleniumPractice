package com.selenium.practice.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");

        /*XPath Locators */
        //1. Exact Match (//tag[@attr='value'])
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        checkElement(loginButton,"exact match");

        //2. Partial Match (//tag[contains(@attr, 'value')])
        WebElement username = driver.findElement(By.xpath("//input[contains(@id, 'user')]"));
        checkElement(username,"partial match");

        //3. Starts With Value (//tag[starts-with(@attr, 'value')])
        WebElement password = driver.findElement(By.xpath("//input[starts-with(@id, 'pass')]"));
        checkElement(password,"starts with");

        //4. Exact Text Content (//tag[text()='exact text'])
        WebElement exactTitleContent = driver.findElement(By.xpath("//h4[text()='Accepted usernames are:']"));
        checkElement(exactTitleContent,"exact text content");

        //5.Multiple Attribute (//tag[@attr1='v1' and @attr2='v2'])
        WebElement multipleAttribute = driver.findElement(By.xpath("//input[@type='submit' and @value='Login']"));
        checkElement(multipleAttribute,"multiple attribute");

        //6. Any Element (//*)
        WebElement anyElement = driver.findElement(By.xpath("//*[contains(text(), 'standard_user')]"));
        checkElement(anyElement,"any element");

        /*CSS Selectors */

        // Generic call
        WebElement usernameCSS = driver.findElement(By.cssSelector("input[data-test='username']"));
        checkElement(usernameCSS, "Generic Call");

        // CSS starts with ^
        WebElement loginBtnStartsWith = driver.findElement(By.cssSelector("input[type^='submit']"));
        checkElement(loginBtnStartsWith, "CSS starts with");

        // Ends With
        WebElement loginButtonEndsWith = driver.findElement(By.cssSelector("input[id$='button']"));
        checkElement(loginButtonEndsWith, "CSS ends-with ($=)");


        // CSS contains * (used for flexible matches)
        WebElement flexibleMatchElement = driver.findElement(By.cssSelector("div[class*='login']"));
        checkElement(flexibleMatchElement, "CSS contains (*)");




        driver.quit();
    }

    public static void checkElement(WebElement element, String strategy) {
        if (element != null) {
            System.out.println("✅ Element found using " + strategy);
        } else {
            System.out.println("❌ Element not found using " + strategy);
        }
    }

}
