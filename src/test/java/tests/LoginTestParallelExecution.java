package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;
import utils.ScreenshotUtils;

import java.time.Duration;


public class LoginTestParallelExecution {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        DriverFactory.quitDriver();
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        // Take screenshot after entering credentials
        ScreenshotUtils.takeScreenshot(driver, "validLogin_" + System.currentTimeMillis());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement inventoryContainer = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("inventory_container"))
        );

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed");

    }

    @Test
    public void invalidLoginTest() throws InterruptedException {
        loginPage.login("invalid_user", "invalid_password");
        // Take screenshot after entering credentials
        ScreenshotUtils.takeScreenshot(driver, "validLogin_" + System.currentTimeMillis());
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertTrue(errorMessage.contains("Username and password do not match"), "Error message not displayed");
    }

    @Test
    public void lockedOutUserTest() throws InterruptedException {
        loginPage.login("locked_out_user", "secret_sauce");
        // Take screenshot after entering credentials
        ScreenshotUtils.takeScreenshot(driver, "validLogin_" + System.currentTimeMillis());
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertTrue(errorMessage.contains("locked out"), "Locked out error not displayed");
    }

    @Test
    public void problemUserTest() throws InterruptedException {
        loginPage.login("problem_user", "secret_sauce");
        // Take screenshot after entering credentials
        ScreenshotUtils.takeScreenshot(driver, "validLogin_" + System.currentTimeMillis());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement inventoryContainer = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("inventory_container"))
        );

        Assert.assertTrue(inventoryContainer.isDisplayed(), "Inventory page did not load");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
