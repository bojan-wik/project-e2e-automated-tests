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

    public WebElement getContactNavigation() {
        return driver.findElement(contactNavigationLocator);
    }
}
