package mystore;

import org.testng.annotations.*;
import mystore.pageobjects.HomePageObjects;
import mystore.pageobjects.LoginPageObjects;
import mystore.resources.Base;

import java.io.IOException;

public class LoginPage extends Base {

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
        HomePageObjects homePageObjects = new HomePageObjects(driver);
        //homePageObjects.getLoginButton().click();
        //LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
        LoginPageObjects loginPageObjects = homePageObjects.clickLoginButton();
        loginPageObjects.getEmailField().sendKeys("test@test.com");
        loginPageObjects.getPasswordField().sendKeys("password");
        loginPageObjects.getSigninButton().click();
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("tear down tests");
        if (driver != null) {
            driver.quit();
        }
    }
}
