package mystore;

import mystore.pageobjects.ContactPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import mystore.pageobjects.HomePage;

import java.io.IOException;

public class ContactPageTests extends TestBase {

    HomePage homePage;
    ContactPage contactPage;

    @BeforeTest
    public void setUpTests() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test
    public void openContactPage() {
        homePage.getContactButton().click();
        String expectedContactNavigationText = "contact";
        String actualContactNavigationText = contactPage.getContactNavigation().getText();
        Assert.assertTrue(actualContactNavigationText.toLowerCase().contains(expectedContactNavigationText));
    }

    @Test
    public void sendValidMessageWithoutFile() {
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
