package academy;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.HomePageObjects;
import pageobjects.LoginPageObjects;
import resources.Base;

import java.io.IOException;

/**
 * Pomiędzy klasami 'Base' i 'HomePage' tworzę relację parent-child. Dzięki temu klasa 'HomePage' ma dostęp do wszystkich
 * metod klasy 'Base'
 */
public class HomePage extends Base {

    /**
     * TO-DO: @BeforeTest uruchamia się na początku danego test folderu, ale tylko raz, co znaczy, że strona z URLem otwierana jest tylko raz,
     * co z kolei prowadzi do tego, że skrypt wywala mi się na testcase 'openHomePage()' - zinwestygować
     */
    /*@BeforeTest
    public void setUpTests() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }*/

    /**
     * Analogicznie jak to robiłem w lekcji 'y_DataProviderAnnotation' tworzę funkcję, która zwróci mi zestaw email & password i otaguję ją adnotacją @DataProvider.
     * Dzięki temu parametryzuję moje test casy i będę mógł w przyszłości uruchamiać je z różnymi zestawami danych
     */
    @DataProvider
    public Object[][] getEmailAndPassword() {
        Object[][] dataSetArray = new Object[2][2];
        // data set 1
        dataSetArray[0][0] = "user1@test.com";
        dataSetArray[0][1] = "password1";
        // data set 2
        dataSetArray[1][0] = "user2@test.com";
        dataSetArray[1][1] = "password2";
        return dataSetArray;
    }

    @Test
    public void openHomePage() throws IOException {
        driver = initializeDriver();
        //driver.get("http://automationpractice.com/index.php");
        /**
         * Jako, że adres URL dla każdego testcase jest taki sam - wynoszę go, jako parametr ('url') do pliku .properties,
         * Wcześniej zmienną 'properties' wyniosłem w klasie 'Base' na poziom global, teraz mam tutaj do niej dostęp,
         * wcześniej wywołana metoda 'initializeDriver()' zasila także zmienną 'properties', dzięki czemu teraz mogę od razu
         * wywołać metodę 'getProperty()' i bezp. zczytać wyniesiony wcześniej parametr 'url'
         */
        driver.get(properties.getProperty("url"));
        HomePageObjects homePageObjects = new HomePageObjects(driver);
        String expectedPageTitle = "Automation Practice Website";
        String actualPageTitle = homePageObjects.getPageTitle().getText();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
        Assert.assertTrue(homePageObjects.getSlider().isDisplayed());
        driver.quit();
    }

    @Test(dataProvider = "getEmailAndPassword")
    public void login(String email, String password) throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        /**
         * Tworzę obiekt klasy 'HomePageObjects', jako argument podaję driver i tym samym przekazuję wiedzę o wcześniej utworzonym i zasilonym driverze
         * do klasy z obiektami dla HomePage.
         */
        HomePageObjects homePageObjects = new HomePageObjects(driver);
        homePageObjects.getLoginButton().click();
        LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
        loginPageObjects.getEmailField().sendKeys(email);
        loginPageObjects.getPasswordField().sendKeys(password);
        loginPageObjects.getSigninButton().click();
        driver.quit();
        /**
         * TO-DO:
         *  1-a: albo wynieść url, email i password do zewn. pliku - wtedy potem dodać ten plik do .gitignore i ew. w przyszłości jakąś enkrypcję,
         *  1-b: albo w kursie jest wspomniany TestNG DataProviders - są o tym lekcje, których jeszcze nie obejrzałem - przerobione,
         *      ale wrażliwe dane są cały czas w skrypcie, więc to nie rozwiązuje głównego problemu
         *  2: wynieść URL do parametru globalnego (np. na poziom test suite), jak już stworzę plik testng.xml
         */
    }

    /*@AfterTest
    public void tearDownTests() {
        System.out.println("tear down tests");
        driver.close();
    }*/
}
