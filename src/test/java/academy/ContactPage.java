package academy;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.ContactPageObjects;
import pageobjects.HomePageObjects;
import resources.Base;

import java.io.IOException;

public class ContactPage extends Base {

    @BeforeTest
    public void setUpTests() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void openContactPage() {
        HomePageObjects homePageObjects = new HomePageObjects(driver);
        homePageObjects.getContactButton().click();
        ContactPageObjects contactPageObjects = new ContactPageObjects(driver);
        String expectedContactNavigationText = "contact";
        String actualContactNavigationText = contactPageObjects.getContactNavigation().getText();
        Assert.assertTrue(actualContactNavigationText.toLowerCase().contains(expectedContactNavigationText));
    }

    public void sendMessage() {}

    @AfterTest
    public void tearDownTests() {
        System.out.println("tear down tests");
        if (driver != null) {
            driver.quit();
        }
    }
}
