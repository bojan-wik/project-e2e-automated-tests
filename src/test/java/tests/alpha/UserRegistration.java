package tests.alpha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.BasePage;
import pageobjects.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Test Case 1 - Automate User Registration Process - Positive Scenario
 * Steps to Automate:
 * 1. Open this url  http://automationpractice.com/index.php - done
 * 2. Click on sign in link.
 * 3. Enter your email address in 'Create and account' section.
 * 4. Click on Create an Account button.
 * 5. Enter your Personal Information, Address and Contact info.
 * 6. Click on Register button.
 * 7. Validate that user is created.
 */

public class UserRegistration {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.home") + "\\IdeaProjects\\project-e2e-automated-tests\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // 1. Open this url  http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");
        // 2. Click on sign in link.
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = basePage.clickLoginButton();
        // 3. Enter your email address in 'Create and account' section.
        loginPage.getCreateAccountEmailField().sendKeys("test");

        //driver.quit();
    }
}
