package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Log In using methods
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        // After clicking Login Button
        Thread.sleep(2000);

        //Validation
        InventoryPage inventoryPage = new InventoryPage(driver);

        if(inventoryPage.isOnInventoryPage() && inventoryPage.getHeaderText().equals("Products")) {
            System.out.println("✅ Login validation passed");
        } else {
            System.out.println("❌ Login validation failed");
        }

        // Exit
        driver.quit();
    }
}
