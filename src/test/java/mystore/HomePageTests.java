package mystore;

import mystore.pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;
import mystore.resources.TestBase;

import java.io.IOException;

/**
 * Pomiędzy klasami 'TestBase' i 'HomePageTests' tworzę relację parent-child. Dzięki temu klasa 'HomePageTests' ma dostęp do wszystkich
 * metod klasy 'TestBase'
 */
public class HomePageTests extends TestBase {

    HomePage homePage;

    /**
     * @BeforeTest : It will call Only once, before Test method.
     * @BeforeMethod It will call Every time before Test Method.
     */
    @BeforeTest
    public void setUpTests() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyPageTitle() {
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
        String expectedPageTitle = "Automation Practice Website";
        String actualPageTitle = homePage.getPageTitle().getText();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
        //driver.quit();
    }

    @Test
    public void verifyPopularAndBestsellersLinks() {
        Assert.assertTrue((homePage.getPopularLink().isDisplayed())
                && (homePage.getBestsellersLink().isDisplayed()));
        // verify that 'Bestsellers' link is not focused by default
        Assert.assertNotEquals(driver.switchTo().activeElement(), homePage.getBestsellersLink());
        // click on 'Bestsellers' link and verify that it is focused now
        homePage.getBestsellersLink().click();
        Assert.assertEquals(driver.switchTo().activeElement(), homePage.getBestsellersLink());
    }

    @AfterTest
    public void tearDownTests() {
        System.out.println("tear down tests");
        /*if (driver != null) {
            driver.quit();
        }*/
    }
}
