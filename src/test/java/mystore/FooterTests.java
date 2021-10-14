package mystore;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import mystore.resources.TestBase;

import java.io.IOException;

public class FooterTests extends TestBase {

    @BeforeTest
    public void setUpTests() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void subscribeToNewsletterWithValidNewEmail() throws IOException {
        mystore.pageobjects.Footer footer = new mystore.pageobjects.Footer(driver);
        String validEmail = generateRandomString() + "@test.com";
        footer.getNewsletterEmailField().sendKeys(validEmail);
        footer.getNewsletterSubmitButton().click();
        String expectedValidNewEmailAlert = "successfully subscribed";
        String actualValidNewEmailAlert = footer.getValidNewEmailAlert().getText();
        Assert.assertTrue(actualValidNewEmailAlert.toLowerCase().contains(expectedValidNewEmailAlert));
    }

    @Test
    public void subscribeToNewsletterWithInvalidEmail() {
        mystore.pageobjects.Footer footer = new mystore.pageobjects.Footer(driver);
        String invalidEmail = generateRandomString();
        footer.getNewsletterEmailField().sendKeys(invalidEmail);
        footer.getNewsletterSubmitButton().click();
        String expectedInvalidEmailAlert = "invalid email address";
        String actualInvalidEmailAlert = footer.getInvalidEmailAlert().getText();
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
