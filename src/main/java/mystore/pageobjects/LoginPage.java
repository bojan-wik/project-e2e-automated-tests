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

    By forgotPasswordHeadingLocator = By.xpath("//h1[@class='page-subheading']");

    public WebElement getEmailField() {
        return driver.findElement(emailFieldLocator);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordFieldLocator);
    }

    public WebElement getForgotPasswordLink() { return driver.findElement(forgotPasswordLinkLocator); }

    public WebElement getSigninButton() {
        return driver.findElement(signinButtonLocator);
    }

    public WebElement getForgotPasswordHeading() { return driver.findElement(forgotPasswordHeadingLocator); }
}
