package mystore;

import mystore.pageobjects.LoginPage;
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

    @Test
    public void login() {
        HomePage homePage = new HomePage(driver);
        //homePage.getLoginButton().click();
        //LoginPage loginPage = new LoginPage(driver);
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.getEmailField().sendKeys("test@test.com");
        loginPage.getPasswordField().sendKeys("password");
        loginPage.getSigninButton().click();
    }

    @Test
    public void forgotPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getForgotPasswordLink().click();
        System.out.println(loginPage.getForgotPasswordHeading().getText());
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("tear down tests");
        if (driver != null) {
            driver.quit();
        }
    }
}
