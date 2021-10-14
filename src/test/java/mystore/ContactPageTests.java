package mystore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import mystore.pageobjects.HomePage;
import mystore.resources.TestBase;

import java.io.IOException;

public class ContactPageTests extends TestBase {

    @BeforeTest
    public void setUpTests() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void openContactPage() {
        HomePage homePage = new HomePage(driver);
        homePage.getContactButton().click();
        mystore.pageobjects.ContactPage contactPage = new mystore.pageobjects.ContactPage(driver);
        String expectedContactNavigationText = "contact";
        String actualContactNavigationText = contactPage.getContactNavigation().getText();
        Assert.assertTrue(actualContactNavigationText.toLowerCase().contains(expectedContactNavigationText));
    }

    @Test
    public void sendValidMessageWithoutFile() {
        mystore.pageobjects.ContactPage contactPage = new mystore.pageobjects.ContactPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(contactPage.getSubjectHeadingDropdown()).click()
                .sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        contactPage.getEmailField().sendKeys(generateRandomString() + "@test.com");
        contactPage.getOrderRefField().sendKeys(Integer.toString(generateRandomInt()));
        contactPage.getMessageField().sendKeys("test message");
        contactPage.getSendButton().click();
        Assert.assertTrue(contactPage.getMessageSentAlert().isDisplayed());
        String actualMessageSentAlert = contactPage.getMessageSentAlert().getText();
        Assert.assertTrue(actualMessageSentAlert.toLowerCase().contains("successfully sent"));
    }

    @AfterTest
    public void tearDownTests() {
        System.out.println("tear down tests");
        if (driver != null) {
            driver.quit();
        }
    }
}
