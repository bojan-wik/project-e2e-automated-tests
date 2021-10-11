package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPageObjects {

    WebDriver driver;
    public ContactPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    By contactNavigationLocator = By.xpath("//span[@class='navigation_page']");
    By messageSubjectHeadingDropdownLocator = By.id("id_contact");
    By messageEmailFieldLocator = By.id("email");

    public WebElement getContactNavigation() {
        return driver.findElement(contactNavigationLocator);
    }

    public WebElement getMessageSubjectHeadingDropdown() {
        return driver.findElement(messageSubjectHeadingDropdownLocator);
    }

    public WebElement getMessageEmailField() {
        return driver.findElement(messageEmailFieldLocator);
    }
}
