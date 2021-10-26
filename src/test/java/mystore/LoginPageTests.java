package mystore;

import mystore.pageobjects.ForgotPasswordPage;
import mystore.pageobjects.LoginPage;
import mystore.pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginPageTests extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeTest
    public void setUpTest() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        //driver.get(properties.getProperty("url") + "?controller=authentication&back=my-account");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void login() {
        //LoginPage loginPage = homePage.clickLoginButton();
        homePage.getLoginButton().click();
        loginPage.getEmailField().sendKeys(properties.getProperty("email"));
        loginPage.getPasswordField().sendKeys(properties.getProperty("password"));
        loginPage.getSigninButton().click();
    }

    @Test(priority = 2)
    public void forgotPassword() {
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPasswordLink();
        Assert.assertTrue(forgotPasswordPage.getForgotPasswordHeading().getText().toLowerCase()
                .contains("forgot your password"));
        forgotPasswordPage.getEmailField().sendKeys(properties.getProperty("email"));
        forgotPasswordPage.getRetrievePasswordButton().click();
        Assert.assertTrue(forgotPasswordPage.getAlertSuccess().getText().toLowerCase()
                .contains("confirmation email has been sent"));
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("tear down tests");
        if (driver != null) {
            driver.quit();
        }
    }
}
