package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailFieldLocator = By.id("email");
    By passwordFieldLocator = By.id("passwd");
    By signinButtonLocator = By.id("SubmitLogin");

    public WebElement getEmailField() {
        return driver.findElement(emailFieldLocator);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordFieldLocator);
    }

    public WebElement getSigninButton() {
        return driver.findElement(signinButtonLocator);
    }
}
