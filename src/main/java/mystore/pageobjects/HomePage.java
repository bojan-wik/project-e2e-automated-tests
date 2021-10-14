package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    //WebDriver driver;
    /*public HomePageObjects(WebDriver driver) {
        this.driver = driver;
    }*/
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //By contactButtonLocator = By.id("contact-link");
    By loginButtonLocator = By.xpath("//a[@class='login']");
    By sliderLocator = By.id("slider_row");
    By pageTitleLocator = By.xpath("//div[@id='editorial_block_center']/h1");

    //public WebElement getContactButton() { return driver.findElement(contactButtonLocator); }

    /*public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }*/
    /**
     * Poprzednia metoda (getLoginButton()) zwracała tylko WebElement login buttona. Potem w testcase wykonywałem na tym webelemencie click
     * i zawsze po tym następowało przejście do strony logowania i musiałem tworzyć obiekt klasy LoginPageObjects.
     * Teraz ten cały proces mam zawarty w metodzie clickLoginButton()
     */
    public LoginPage clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }

    public WebElement getSlider() { return driver.findElement(sliderLocator); }
    public WebElement getPageTitle() { return driver.findElement(pageTitleLocator); }
}
