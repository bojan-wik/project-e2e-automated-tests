package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

    WebDriver driver;
    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    By emailFieldLocator = By.id("email");
    By passwordFieldLocator = By.id("passwd");
    By signinButtonLocator = By.id("SubmitLogin");

    public WebElement emailField() {
        return driver.findElement(emailFieldLocator);
    }

    public WebElement passwordField() {
        return driver.findElement(passwordFieldLocator);
    }

    public WebElement signinButton() {
        return driver.findElement(signinButtonLocator);
    }
}
