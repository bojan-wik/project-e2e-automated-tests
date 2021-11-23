package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By createAccountEmailFieldLocator = By.id("email_create");
    private final By emailFieldLocator = By.id("email");
    private final By passwordFieldLocator = By.id("passwd");
    private final By forgotPasswordLinkLocator = By.cssSelector("[href*='controller=password']");
    private final By signinButtonLocator = By.id("SubmitLogin");

    public WebElement getCreateAccountEmailField() { return driver.findElement(createAccountEmailFieldLocator); }
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
