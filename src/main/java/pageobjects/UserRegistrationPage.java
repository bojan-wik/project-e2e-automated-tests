package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistrationPage extends BasePage {

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By genderMisterRadioButtonLocator = By.id("uniform-id_gender1");
    private final By genderMissesRadioButtonLocator = By.id("uniform-id_gender2");
    private final By registerButtonLocator = By.id("submitAccount");

    public WebElement getGenderMisterRadioButton() {return driver.findElement(genderMisterRadioButtonLocator); }
    public WebElement getGenderMissesRadioButton() {return driver.findElement(genderMissesRadioButtonLocator); }
    public WebElement getRegisterButton() {return driver.findElement(registerButtonLocator); }
}
