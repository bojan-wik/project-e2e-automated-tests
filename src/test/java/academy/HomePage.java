package academy;

import org.testng.annotations.Test;
import pageobjects.HomePageObjects;
import pageobjects.LoginPageObjects;
import resources.Base;

import java.io.IOException;

/**
 * Pomiędzy klasami 'Base' i 'HomePage' tworzę relację parent-child. Dzięki temu klasa 'HomePage' ma dostęp do wszystkich
 * metod klasy 'Base'
 */
public class HomePage extends Base {

    @Test
    public void openHomePage() throws IOException {
        driver = initializeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.quit();
    }

    @Test
    public void login() throws IOException {
        driver = initializeDriver();
        driver.get("http://automationpractice.com/index.php");
        /**
         * Tworzę obiekt klasy 'HomePageObjects', jako argument podaję driver i tym samym przekazuję wiedzę o wcześniej zainicjalizowanym driverze
         * do klasy z obiektami dla HomePage.
         */
        HomePageObjects homePageObjects = new HomePageObjects(driver);
        homePageObjects.loginButton().click();
        LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
        loginPageObjects.emailField().sendKeys("wiktor.bojanowski@contractors.roche.com");
        loginPageObjects.passwordField().sendKeys("testpass");
        loginPageObjects.signinButton().click();
        //driver.quit();
    }
}
