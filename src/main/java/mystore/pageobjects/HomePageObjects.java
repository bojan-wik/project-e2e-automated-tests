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

    /*public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }*/
    /**
     * Poprzednia metoda (getLoginButton()) zwracała tylko WebElement login buttona. Potem w testcase wykonywałem na tym webelemencie click
     * i zawsze po tym następowało przejście do strony logowania i musiałem tworzyć obiekt klasy LoginPageObjects.
     * Teraz ten cały proces mam zawarty w metodzie clickLoginButton()
     */
    public LoginPageObjects clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
        LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
        return loginPageObjects;
    }

    public WebElement getSlider() { return driver.findElement(sliderLocator); }
    public WebElement getPageTitle() { return driver.findElement(pageTitleLocator); }
}
