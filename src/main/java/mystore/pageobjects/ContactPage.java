package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {

    WebDriver driver;
    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    By contactNavigationLocator = By.xpath("//span[@class='navigation_page']");
    By subjectHeadingDropdownLocator = By.id("id_contact");
    By emailFieldLocator = By.id("email");
    By orderRefFieldLocator = By.id("id_order");
    By messageFieldLocator = By.id("message");
    By sendButtonLocator = By.id("submitMessage");
    By messageSentAlertLocator = By.xpath("//div[@id='center_column']/p");

    public WebElement getContactNavigation() {
        return driver.findElement(contactNavigationLocator);
    }
    public WebElement getSubjectHeadingDropdown() { return driver.findElement(subjectHeadingDropdownLocator); }
    public WebElement getEmailField() {
        return driver.findElement(emailFieldLocator);
    }
    public WebElement getOrderRefField() { return driver.findElement(orderRefFieldLocator); }
    public WebElement getMessageField() { return driver.findElement(messageFieldLocator); }
    public WebElement getSendButton() { return driver.findElement(sendButtonLocator); }
    public WebElement getMessageSentAlert() { return driver.findElement(messageSentAlertLocator); }
}
