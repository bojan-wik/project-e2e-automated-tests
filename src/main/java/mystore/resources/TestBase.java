package mystore.resources;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Jest to klasa bazowa dla mojego frameworka, która będzie uruchamiana za każdym razem, kiedy framework będzie odpalany.
 */

public class TestBase {

    /**
     * a) Dobrą praktyką jest tworzenie obiektu klasy WebDriver, jako global variable, a nie wewn. metody.
     *    Dzięki temu mogę potem, w zależności od przeglądarki, do zmiennej 'driver' przypisywać odpowiadającą danej przeglądarce klasę np. 'ChromeDriver'
     * b) Wynoszę też zmienną 'properties' na poziom global. Dzięki temu child-klasy (np. 'HomePage') tej klasy będą miały do niej bezp. dostęp.
     */
    public WebDriver driver;
    public Properties properties;

    /**
     * Tworzę metodę, która będzie odpowiedzialna za inicjalizowanie drivera. Wszystkie stworzone później test casy będą korzystały z tej właśnie metody.
     * Dane dot. poszczególnych przeglądarek nie będą hardkodowane, tylko zaciągana z zewn. pliku (patrz 'Chapter19_GlobalEnvVariables')
     */
    public WebDriver initializeDriver() throws IOException {
        properties = new Properties();
        FileInputStream propertiesFileInput = new FileInputStream(System.getProperty("user.home") + "\\IdeaProjects\\project-e2e-automated-tests\\src\\main\\java\\mystore\\resources\\data.properties");
        properties.load(propertiesFileInput);
        String browser = properties.getProperty("browser");
        System.out.printf("I'm starting execution of a test case in a browser: %s\n", browser);
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "\\IdeaProjects\\project-e2e-automated-tests\\webdrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "\\IdeaProjects\\project-e2e-automated-tests\\webdrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        /**
         * Na koniec zwracam przygotowany obiekt 'driver', który będzie używany przez każdy test case
         */
        return driver;
    }

    public String generateRandomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(8);
        return generatedString;
    }

    public int generateRandomInt() {
        int generatedInt = RandomUtils.nextInt(1, 10000);
        return generatedInt;
    }
}

