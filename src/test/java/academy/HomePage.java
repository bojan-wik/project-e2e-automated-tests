package academy;

import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.HomePageObjects;
import resources.Base;

import java.io.IOException;

/**
 * Pomiędzy klasami 'Base' i 'HomePage' tworzę relację parent-child. Dzięki temu klasa 'HomePage' ma dostęp do wszystkich
 * metod klasy 'Base'
 */
public class HomePage extends Base {

    /**
     * @BeforeTest : It will call Only once, before Test method.
     * @BeforeMethod It will call Every time before Test Method.
     */
    @BeforeTest
    public void setUpTests() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void openHomePage() {
        /**
         * Kroki inicjalizowania drivera, otwierania URLa i zamykania drivera powtarzają się w każdym test case - z tego powodu wynoszę je
         * do metod setUpTest() i tearDownTest() żeby ich nie powtarzać co testcase
         */
        //driver = initializeDriver();
        //driver.get("http://automationpractice.com/index.php");
        /**
         * Jako, że adres URL dla każdego testcase jest taki sam - wynoszę go, jako parametr ('url') do pliku .properties,
         * Wcześniej zmienną 'properties' wyniosłem w klasie 'Base' na poziom global, teraz mam tutaj do niej dostęp,
         * wcześniej wywołana metoda 'initializeDriver()' zasila także zmienną 'properties', dzięki czemu teraz mogę od razu
         * wywołać metodę 'getProperty()' i bezp. zczytać wyniesiony wcześniej parametr 'url'
         */
        //driver.get(properties.getProperty("url"));
        HomePageObjects homePageObjects = new HomePageObjects(driver);
        String expectedPageTitle = "Automation Practice Website";
        String actualPageTitle = homePageObjects.getPageTitle().getText();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
        Assert.assertTrue(homePageObjects.getSlider().isDisplayed());
        //driver.quit();
    }

    @Test
    public void subscribeToNewsletterWithInvalidEmail() {
        HomePageObjects homePageObjects = new HomePageObjects(driver);
        String invalidEmail = generateRandomString();
        homePageObjects.getNewsletterEmailField().sendKeys(invalidEmail);
        homePageObjects.getNewsletterSubmitButton().click();
        String expectedInvalidEmailAlert = "invalid email address";
        String actualInvalidEmailAlert = homePageObjects.getInvalidEmailAlert().getText();
        /**
         * Sprawdzam jedynie, czy fraza "invalid email address" jest obecna. W przyszłości cały komunikat alertu może się zmieniać
         * np. coś może być z małej litery, coś z dużej, zamiast dwukropka myślnik, albo gdzieś dodana spacja, dlatego myślę,
         * że nie ma sensu sprawdzać, czy cały komunikat jest dokładnie taki sam - dzięki temu test jest bardziej generyczny i odporny na drobne zmiany.
         */
        Assert.assertTrue(actualInvalidEmailAlert.toLowerCase().contains(expectedInvalidEmailAlert));
    }

    /*public void subscribeToNewsletterWithValidNewEmail() {
        HomePageObjects homePageObjects = new HomePageObjects(driver);

    }*/

    @AfterTest
    public void tearDownTests() {
        System.out.println("tear down tests");
        /*if (driver != null) {
            driver.quit();
        }*/
    }
}
