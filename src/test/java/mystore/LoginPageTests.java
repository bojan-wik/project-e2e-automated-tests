package mystore;

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
        /**
         * Tworzę obiekt klasy 'HomePageObjects', jako argument podaję driver i tym samym przekazuję wiedzę o wcześniej utworzonym i zasilonym driverze
         * do klasy z obiektami dla HomePage.
         */
        HomePage homePageObjects = new HomePage(driver);
        //homePageObjects.getLoginButton().click();
        //LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
        mystore.pageobjects.LoginPage loginPage = homePageObjects.clickLoginButton();
        loginPage.getEmailField().sendKeys("test@test.com");
        loginPage.getPasswordField().sendKeys("password");
        loginPage.getSigninButton().click();
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("tear down tests");
        if (driver != null) {
            driver.quit();
        }
    }
}
