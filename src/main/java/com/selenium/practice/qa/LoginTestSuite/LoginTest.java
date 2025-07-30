package com.selenium.practice.qa.LoginTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.practice.utils.PageFunctions;

import java.util.ArrayList;

public class LoginTest {
    public static void main(String[] args) {
        ArrayList<LoginData> loginDataList = new ArrayList<LoginData>();

        LoginData loginData1 = new LoginData("TC01","standard_user","secret_sauce");
        loginDataList.add(loginData1);

        LoginData loginData2 = new LoginData("TC02","locked_out_user","secret_sauce");
        loginDataList.add(loginData2);

        LoginData loginData3 = new LoginData("TC03","invalid_user","secret_sauce");
        loginDataList.add(loginData3);

        for(LoginData data : loginDataList) {
            WebDriver driver = new ChromeDriver();
            PageFunctions.openPage(driver,"https://www.saucedemo.com");
            login(driver,data);
            checkLoginResult(driver,data);
            PageFunctions.quitPage(driver);
            TestLogger.log(data);
        }
    }

    public static void login(WebDriver driver, LoginData loginData) {
        WebElement username = driver.findElement(By.cssSelector("input[name='user-name']"));
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[name='login-button']"));

        // Input username
        username.clear();
        username.sendKeys(loginData.getUsername());

        // Input password
        password.clear();
        password.sendKeys(loginData.getPassword());

        // Login button
        if (loginButton.isDisplayed()) {
            loginButton.click();
        }
    }

    public static void checkLoginResult(WebDriver driver, LoginData loginData) {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.equals(expectedUrl)) {
            loginData.setResult("PASS");
        }
        else {
            try {
                WebElement error = driver.findElement(By.cssSelector("div[class='error-message-container error']"));
                if (error.isDisplayed()) {
                    loginData.setResult("FAIL: " + error.getText());
                }
            } catch (Exception e) {
                loginData.setResult("FAIL: Unknown error or element not found");
            }

        }
    }
}
