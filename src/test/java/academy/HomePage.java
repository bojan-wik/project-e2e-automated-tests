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
    public void setUpTest() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void openHomePage() {
        /**
         * Kroki inicjalizowania drivera, wywoływania url i zamykania drivera powtarzają się w każdym test case - z tego powodu wynoszę je
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

    @AfterTest
    public void tearDownTest() {
        System.out.println("tear down tests");
        if (driver != null) {
            driver.quit();
        }
    }
}
