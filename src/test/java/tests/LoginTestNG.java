package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import utils.DriverFactory;

public class LoginTestNG {

    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Thread.sleep(2000);

        //Assertions using TestNG
        Assert.assertTrue(inventoryPage.isOnInventoryPage(),"User not redirected to inventory page");
        Assert.assertEquals(inventoryPage.getHeaderText(),"Products","Header text is not correct");
    }

    @Test
    public void testLockedOutUser() throws InterruptedException {
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Thread.sleep(2000);

        // Check for error message
        String errorText = loginPage.getErrorMessage();
        Assert.assertTrue(errorText.contains("locked out"), "Expected locked out error message");
    }

    @Test
    public void testInvalidPassword() throws InterruptedException {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLoginButton();

        Thread.sleep(2000);

        // Check for error message
        String errorText = loginPage.getErrorMessage();
        Assert.assertTrue(errorText.contains("Username and password do not match"), "Expected invalid credentials error");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
