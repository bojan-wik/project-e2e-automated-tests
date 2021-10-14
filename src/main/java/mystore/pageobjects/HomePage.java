package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    //WebDriver driver;
    /*public HomePageObjects(WebDriver driver) {
        this.driver = driver;
    }*/
    /**
     * Wcześniej w każdej pageobjects-class tworzyłem obiekt klasy driver, który był zasilany w każdej test-class i przekazywany tutaj.
     * Teraz ten zasilony driver przekazywany jest nie tutaj, a idzie dalej - do klasy parent, za pośrednictwem super(driver).
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By sliderLocator = By.id("slider_row");
    By pageTitleLocator = By.xpath("//div[@id='editorial_block_center']/h1");

    public WebElement getSlider() { return driver.findElement(sliderLocator); }
    public WebElement getPageTitle() { return driver.findElement(pageTitleLocator); }
}
