package mystore;

import mystore.pageobjects.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewsletterTests extends TestBase {

    BasePage basePage;

    @BeforeTest
    public void setUpTests() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        basePage = new BasePage(driver);
    }

    @Test
    public void subscribeToNewsletterWithValidNewEmail() {
        String validEmail = generateRandomString() + "@test.com";
        basePage.getNewsletterEmailField().sendKeys(validEmail);
        basePage.getNewsletterSubmitButton().click();
        String expectedValidNewEmailAlert = "successfully subscribed";
        String actualValidNewEmailAlert = basePage.getAlertSuccess().getText();
        Assert.assertTrue(actualValidNewEmailAlert.toLowerCase().contains(expectedValidNewEmailAlert));
    }

    @Test
    public void subscribeToNewsletterWithInvalidEmail() {
        String invalidEmail = generateRandomString();
        basePage.getNewsletterEmailField().sendKeys(invalidEmail);
        basePage.getNewsletterSubmitButton().click();
        String expectedInvalidEmailAlert = "invalid email address";
        String actualInvalidEmailAlert = basePage.getAlertFail().getText();
        /**
         * Sprawdzam jedynie, czy fraza "invalid email address" jest obecna. W przyszłości cały komunikat alertu może się zmieniać
         * np. coś może być z małej litery, coś z dużej, zamiast dwukropka myślnik, albo gdzieś dodana spacja, dlatego myślę,
         * że nie ma sensu sprawdzać, czy cały komunikat jest dokładnie taki sam - dzięki temu test jest bardziej generyczny i odporny na drobne zmiany.
         */
        Assert.assertTrue(actualInvalidEmailAlert.toLowerCase().contains(expectedInvalidEmailAlert));
    }

    @AfterTest
    public void tearDownTests() {
        System.out.println("tear down tests");
        if (driver != null) {
            driver.quit();
        }
    }
}
