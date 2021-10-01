package Academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Jest to klasa bazowa dla mojego frameworka, która będzie uruchamiana za każdym razem, kiedy framework będzie odpalany.
 */

public class Base {

    /**
     * Dobrą praktyką jest tworzenie obiektu klasy WebDriver, jako global variable, a nie wewn. metody.
     * Dzięki temu mogę potem, w zależności od przeglądarki, do zmiennej 'driver' przypisywać odpowiadającą danej przeglądarce klasę np. 'ChromeDriver'
     */
    public WebDriver driver;

    /**
     * Tworzę metodę, która będzie odpowiedzialna za inicjalizowanie drivera. Wszystkie stworzone później test casy będą korzystały z tej właśnie metody.
     * Dane dot. poszczególnych przeglądarek nie będą hardkodowane, tylko zaciągana z zewn. pliku (patrz 'Chapter19_GlobalEnvVariables')
     */
    public WebDriver initializeDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream propertiesFileInput = new FileInputStream("C:\\Users\\bojanoww\\IdeaProjects\\project-e2e-automated-tests\\src\\main\\java\\Academy\\browser_data.properties");
        properties.load(propertiesFileInput);
        String browser = properties.getProperty("browser");
        System.out.printf("I'm starting execution of a test case in a browser: %s\n", browser);
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\93\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Tools\\Webdrivers\\Firefox\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        /**
         * Na koniec zwracam przygotowany obiekt 'driver', który będzie używany przez każdy test case
         */
        return driver;
    }
}

