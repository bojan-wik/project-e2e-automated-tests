package tests;

import pageobjects.ContactPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.HomePage;

import java.io.IOException;

public class ContactPageTests extends TestBase {

    HomePage homePage;
    ContactPage contactPage;

    @BeforeTest
    public void setUpTests() throws IOException {
        logger.info("Setting up test-class: {}", this.getClass().getSimpleName());
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        logger.info("Home page accessed");
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test
    public void openContactPage() {
        homePage.getContactButton().click();
        String expectedContactNavigationText = "contact";
        String actualContactNavigationText = contactPage.getContactNavigation().getText();
        Assert.assertTrue(actualContactNavigationText.toLowerCase().contains(expectedContactNavigationText));
        logger.info("Contact page accessed");
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
        logger.info("Valid message without file sent. Correct message is displayed");
    }

    @AfterTest
    public void tearDownTests() {
        logger.info("Tearing down test-class: {}", this.getClass().getSimpleName());
        if (driver != null) {
            driver.quit();
        }
    }
}
