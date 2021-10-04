package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {

    WebDriver driver;
    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
    }

    By loginButtonLocator = By.xpath("//a[@class='login']");

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }
}
