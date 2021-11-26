package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistrationPage extends BasePage {

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By titleMrRadioButtonLocator = By.id("id_gender1");
    //private final By titleMrsRadioButtonLocator = By.id("id_gender2");
    private final By firstNameFieldLocator = By.id("customer_firstname");
    private final By lastNameFieldLocator = By.id("customer_lastname");
    private final By registerButtonLocator = By.id("submitAccount");

    public WebElement getTitleMrRadioButton() {return driver.findElement(titleMrRadioButtonLocator); }
    //public WebElement getTitleMrsRadioButton() {return driver.findElement(titleMrsRadioButtonLocator); }
    public WebElement getFirstNameField() {return driver.findElement(firstNameFieldLocator); }
    public WebElement getLastNameField() {return driver.findElement(lastNameFieldLocator); }
    public WebElement getRegisterButton() {return driver.findElement(registerButtonLocator); }
}
