package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    private final By contactNavigationLocator = By.xpath("//span[@class='navigation_page']");
    private final By subjectHeadingDropdownLocator = By.id("id_contact");
    private final By emailFieldLocator = By.id("email");
    private final By orderRefFieldLocator = By.id("id_order");
    private final By messageFieldLocator = By.id("message");
    private final By sendButtonLocator = By.id("submitMessage");
    private final By messageSentAlertLocator = By.xpath("//div[@id='center_column']/p");

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
