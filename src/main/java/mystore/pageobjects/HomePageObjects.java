package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {

    WebDriver driver;
    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
    }

    By contactButtonLocator = By.id("contact-link");
    By loginButtonLocator = By.xpath("//a[@class='login']");
    By sliderLocator = By.id("slider_row");
    By pageTitleLocator = By.xpath("//div[@id='editorial_block_center']/h1");

    public WebElement getContactButton() { return driver.findElement(contactButtonLocator); }
    public WebElement getLoginButton() { return driver.findElement(loginButtonLocator); }
    public WebElement getSlider() { return driver.findElement(sliderLocator); }
    public WebElement getPageTitle() { return driver.findElement(pageTitleLocator); }
}
