package tests.alpha;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import tests.TestBase;

import java.io.IOException;

public class LoginPageTests_DataProvider extends TestBase {

    @BeforeTest
    public void setUpTest() throws IOException {
        System.out.println("set up tests");
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
    }

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

    /*@Test(dataProvider = "getEmailAndPassword")
    public void login(String email, String password) {
        HomePageObjects homePageObjects = new HomePageObjects(driver);
        homePageObjects.getLoginButton().click();
        LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
        loginPageObjects.getEmailField().sendKeys(email);
        loginPageObjects.getPasswordField().sendKeys(password);
        loginPageObjects.getSigninButton().click();
    }*/

    @AfterTest
    public void tearDownTest() {
        System.out.println("tear down tests");
        if (driver != null) {
            driver.quit();
        }
    }
}
/**
 * TO-DO:
 *  1-a: albo wynieść url, email i password do zewn. pliku - wtedy potem dodać ten plik do .gitignore i ew. w przyszłości jakąś enkrypcję,
 *  1-b: albo w kursie jest wspomniany TestNG DataProviders - są o tym lekcje, których jeszcze nie obejrzałem - przerobione,
 *      ale wrażliwe dane są cały czas w skrypcie, więc to nie rozwiązuje głównego problemu
 *  2: wynieść URL do parametru globalnego (np. na poziom test suite), jak już stworzę plik testng.xml
 */
