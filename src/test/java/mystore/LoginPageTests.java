package mystore;

import mystore.pageobjects.ForgotPasswordPage;
import mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;
import mystore.pageobjects.HomePage;
import mystore.resources.TestBase;

import java.io.IOException;

public class LoginPageTests extends TestBase {

    @BeforeTest
    public void setUpTest() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

    @Test(priority = 1)
    public void login() {
        HomePage homePage = new HomePage(driver);
        //homePage.getLoginButton().click();
        //LoginPage loginPage = new LoginPage(driver);
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.getEmailField().sendKeys("test@test.com");
        loginPage.getPasswordField().sendKeys("password");
        loginPage.getSigninButton().click();
    }

    @Test(priority = 2)
    public void forgotPassword() {
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPasswordLink();
        Assert.assertTrue(forgotPasswordPage.getForgotPasswordHeading().getText().toLowerCase().contains("forgot your password"));
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("tear down tests");
        if (driver != null) {
            driver.quit();
        }
    }
}
