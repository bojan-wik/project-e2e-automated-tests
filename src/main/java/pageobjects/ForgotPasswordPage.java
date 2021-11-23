package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    private final By emailFieldLocator = By.id("email");
    private final By retrievePasswordButtonLocator = By.xpath("//form[@id='form_forgotpassword']/fieldset/p/button");

    public WebElement getEmailField() {
        return driver.findElement(emailFieldLocator);
    }
    public WebElement getRetrievePasswordButton() {
        return driver.findElement(retrievePasswordButtonLocator);
    }
}
