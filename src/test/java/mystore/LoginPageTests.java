package mystore;

import mystore.pageobjects.ForgotPasswordPage;
import mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;
import mystore.resources.TestBase;

import java.io.IOException;

public class LoginPageTests extends TestBase {

    @BeforeTest
    public void setUpTest() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        //driver.get(properties.getProperty("url"));
        //na potrzeby pisania forgotPassword()
        driver.get(properties.getProperty("url") + "?controller=authentication&back=my-account");
    }

    /*@Test(priority = 1)
    public void login() {
        HomePage homePage = new HomePage(driver);
        //homePage.getLoginButton().click();
        //LoginPage loginPage = new LoginPage(driver);
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.getEmailField().sendKeys(properties.getProperty("email"));
        loginPage.getPasswordField().sendKeys(properties.getProperty("password"));
        loginPage.getSigninButton().click();
    }*/

    @Test(priority = 2)
    public void forgotPassword() {
        LoginPage loginPage = new LoginPage(driver);
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
