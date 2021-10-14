package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {

    WebDriver driver;
    public Footer(WebDriver driver) {
        this.driver = driver;
    }

    By newsletterEmailFieldLocator = By.id("newsletter-input");
    By newsletterSubmitButtonLocator = By.xpath("//button[@name='submitNewsletter']");
    By invalidEmailAlertLocator = By.className("alert-danger");
    By validNewEmailAlertLocator = By.className("alert-success");

    public WebElement getNewsletterEmailField() { return driver.findElement(newsletterEmailFieldLocator); }
    public WebElement getNewsletterSubmitButton() { return driver.findElement(newsletterSubmitButtonLocator); }
    public WebElement getInvalidEmailAlert() { return driver.findElement(invalidEmailAlertLocator); }
    public WebElement getValidNewEmailAlert() { return driver.findElement(validNewEmailAlertLocator); }
}
