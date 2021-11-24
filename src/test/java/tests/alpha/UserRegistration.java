package tests.alpha;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageobjects.BasePage;
import pageobjects.LoginPage;
import pageobjects.UserRegistrationPage;
import tests.TestBase;

import java.util.concurrent.TimeUnit;

/**
 * Test Case 1 - Automate User Registration Process - Positive Scenario
 * Steps to Automate:
 * 1. Open this url  http://automationpractice.com/index.php - done
 * 2. Click on sign in link. - done
 * 3. Enter your email address in 'Create and account' section. - done
 * 4. Click on Create an Account button. - done
 * 5. Enter your Personal Information, Address and Contact info.
 * 6. Click on Register button.
 * 7. Validate that user is created.
 */

public class UserRegistration extends TestBase {

    public static Logger logger = LogManager.getLogger(UserRegistration.class.getName());

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.home") + "\\IdeaProjects\\project-e2e-automated-tests\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(driver);

        // 1. Open this url  http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");
        // 2. Click on sign in link.
        basePage.getLoginButton().click();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("login"));
        logger.info("Login page accessed");
        // 3. Enter your email address in 'Create and account' section.
        String validEmail = generateRandomString() + "@test.com";
        loginPage.getCreateAccountEmailField().sendKeys(validEmail);
        // 4. Click on Create an Account button.
        loginPage.getCreateAccountButton().click();
        Assert.assertTrue(userRegistrationPage.getRegisterButton().isDisplayed());
        logger.info("User registration page accessed");
        // 5. Enter your Personal Information, Address and Contact info.
        //Assert.assertTrue(userRegistrationPage.getGenderMisterRadioButton().isSelected());
        userRegistrationPage.getGenderMisterRadioButton().click();
        Assert.assertTrue(userRegistrationPage.getGenderMisterRadioButton().isSelected());

        // 6. Click on Register button.
        //userRegistrationPage.getRegisterButton().click();
        // 7. Validate that user is created.

        //driver.quit();
    }
}
