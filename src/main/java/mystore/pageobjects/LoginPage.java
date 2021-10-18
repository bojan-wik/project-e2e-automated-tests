package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailFieldLocator = By.id("email");
    By passwordFieldLocator = By.id("passwd");
    By forgotPasswordLinkLocator = By.cssSelector("[href*='controller=password']");
    By signinButtonLocator = By.id("SubmitLogin");



    public WebElement getEmailField() {
        return driver.findElement(emailFieldLocator);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordFieldLocator);
    }

    /**
     * Robię ten sam zabieg, co w przypadku BasePage.clickLoginButton()
     */
    public ForgotPasswordPage clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLinkLocator).click();
        return new ForgotPasswordPage(driver);
    }

    public WebElement getSigninButton() {
        return driver.findElement(signinButtonLocator);
    }
}
