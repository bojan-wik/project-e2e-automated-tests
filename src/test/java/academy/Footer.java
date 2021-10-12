package academy;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.FooterObjects;
import resources.Base;

import java.io.IOException;

public class Footer extends Base {

    @BeforeTest
    public void setUpTests() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void subscribeToNewsletterWithValidNewEmail() throws IOException {
        FooterObjects footerObjects = new FooterObjects(driver);
        String validEmail = generateRandomString() + "@test.com";
        footerObjects.getNewsletterEmailField().sendKeys(validEmail);
        footerObjects.getNewsletterSubmitButton().click();
        String expectedValidNewEmailAlert = "successfully subscribed";
        String actualValidNewEmailAlert = footerObjects.getValidNewEmailAlert().getText();
        Assert.assertTrue(actualValidNewEmailAlert.toLowerCase().contains(expectedValidNewEmailAlert));
    }

    @Test
    public void subscribeToNewsletterWithInvalidEmail() {
        FooterObjects footerObjects = new FooterObjects(driver);
        String invalidEmail = generateRandomString();
        footerObjects.getNewsletterEmailField().sendKeys(invalidEmail);
        footerObjects.getNewsletterSubmitButton().click();
        String expectedInvalidEmailAlert = "invalid email address";
        String actualInvalidEmailAlert = footerObjects.getInvalidEmailAlert().getText();
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
