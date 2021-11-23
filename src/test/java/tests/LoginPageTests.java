package tests;

import pageobjects.ForgotPasswordPage;
import pageobjects.LoginPage;
import pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginPageTests extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeTest
    public void setUpTest() throws IOException {
        logger.info("Setting up test-class: {}", this.getClass().getSimpleName());
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        logger.info("Home page accessed");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void login() {
        LoginPage loginPage = homePage.clickLoginButton();
        //homePage.getLoginButton().click();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("login"));
        logger.info("Login page accessed");
        loginPage.getEmailField().sendKeys(properties.getProperty("email"));
        loginPage.getPasswordField().sendKeys(properties.getProperty("password"));
        loginPage.getSigninButton().click();
        logger.info("Login successful");
    }

    @Test(priority = 2)
    public void forgotPassword() {
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPasswordLink();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("forgot your password"));
        logger.info("Forgot password page accessed");
        forgotPasswordPage.getEmailField().sendKeys(properties.getProperty("email"));
        forgotPasswordPage.getRetrievePasswordButton().click();
        Assert.assertTrue(forgotPasswordPage.getAlertSuccess().getText().toLowerCase()
                .contains("confirmation email has been sent"));
        logger.info("Confirmation email sent");
    }

    @AfterTest
    public void tearDownTest() {
        logger.info("Tearing down test-class: {}", this.getClass().getSimpleName());
        if (driver != null) {
            driver.quit();
        }
    }
}
