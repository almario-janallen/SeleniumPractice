package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import utils.ExcelUtils;

import org.testng.annotations.Listeners;
import listeners.TestListener;

@Listeners(TestListener.class)
public class LoginTestNG extends BaseTest{

    LoginPage loginPage;

//    @Test
//    public void testValidLogin() throws InterruptedException {
//        loginPage.enterUsername("standard_user");
//        loginPage.enterPassword("secret_sauce");
//        loginPage.clickLoginButton();
//
//        Thread.sleep(2000);
//
//        //Assertions using TestNG
//        Assert.assertTrue(inventoryPage.isOnInventoryPage(),"User not redirected to inventory page");
//        Assert.assertEquals(inventoryPage.getHeaderText(),"Products","Header text is not correct");
//    }
//
//    @Test
//    public void testLockedOutUser() throws InterruptedException {
//        loginPage.enterUsername("locked_out_user");
//        loginPage.enterPassword("secret_sauce");
//        loginPage.clickLoginButton();
//
//        Thread.sleep(2000);
//
//        // Check for error message
//        String errorText = loginPage.getErrorMessage();
//        Assert.assertTrue(errorText.contains("locked out"), "Expected locked out error message");
//    }
//
//    @Test
//    public void testInvalidPassword() throws InterruptedException {
//        loginPage.enterUsername("standard_user");
//        loginPage.enterPassword("wrong_password");
//        loginPage.clickLoginButton();
//
//        Thread.sleep(2000);
//
//        // Check for error message
//        String errorText = loginPage.getErrorMessage();
//        Assert.assertTrue(errorText.contains("Username and password do not match"), "Expected invalid credentials error");
//    }

//    @DataProvider(name = "loginData")
//    public Object[][] getLoginData() {
//        return new Object[][] {
//                {"standard_user", "secret_sauce",true},     // valid login
//                {"locked_out_user", "secret_sauce",false},  // locked out
//                {"standard_user","wrong_password",false}    // invalid password
//        };
//    }
//
//    @Test(dataProvider = "loginData")
//    public void testLoginScenarios(String username, String password, boolean isSuccess) {
//        LoginPage loginPage = new LoginPage(driver);
//
//        // Perform login
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//        loginPage.clickLoginButton();
//
//        if(isSuccess) {
//            // Validate successful login
//            String currentUrl = driver.getCurrentUrl();
//            Assert.assertTrue(currentUrl.contains("inventory.html"),"Expected to land on inventory page for user: " + username);
//        } else {
//            // Validate error message
//            String errorMessage = loginPage.getErrorMessage();
//            Assert.assertTrue(!errorMessage.isEmpty(),"Expected to see error message for user: " + username);
//        }
//    }

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
        String filePath = "src/test/resources/testdata/LoginData.xlsx";
        return ExcelUtils.getExcelData(filePath,"Sheet1");
    }

    @Test(dataProvider = "excelData")
    public void testLoginScenariosFromExcel(String username, String password, boolean isSuccess) {
        loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        if(isSuccess) {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),"Expected to land on inventory page for user: " + username);
        } else {
            // Validate error message
            String errorMessage = loginPage.getErrorMessage();
            Assert.assertTrue(!errorMessage.isEmpty(),"Expected to see error message for user: " + username);
        }
    }
}
