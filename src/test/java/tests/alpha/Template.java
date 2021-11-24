package tests.alpha;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.TestBase;

import java.util.concurrent.TimeUnit;

public class Template extends TestBase {

    public static Logger logger = LogManager.getLogger(Template.class.getName());

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.home") + "\\IdeaProjects\\project-e2e-automated-tests\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://automationpractice.com/index.php");

        //driver.quit();
    }
}
