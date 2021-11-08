package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.HomePage;

import java.io.IOException;

/**
 * Assignment 3 - Automate 'Search Product' functionality of an e-commerce website
 * Test Case 1- Automate 'Search Product' Functionality of an e-commerce website with Selenium
 * Steps to Automate:
 * 1. Open link http://automationpractice.com/index.php - done
 * 2. Move your cursor over Women's link.
 * 3. Click on sub menu 'T-shirts' -
 * 4. Get Name/Text of the first product displayed on the page.
 * 5. Now enter the same product name in the search bar present on top of page and click search button.
 * 6. Validate that same product is displayed on searched page with same details which were displayed on T-Shirt's page.
 */

public class SearchProduct extends TestBase {

    BasePage basePage;
    Actions actions;

    @BeforeTest
    public void setUpTests() throws IOException {
        logger.info("Setting up {} test-class", this.getClass().getSimpleName());
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        logger.info("HomePage accessed");
        basePage = new BasePage(driver);
        actions = new Actions(driver);
    }

    @Test
    public void testCase1() {
        System.out.println("test case 1");
        //basePage.getWomenLink().click();
        actions.moveToElement(basePage.getWomenLink()).click().build().perform();
        //actions.moveToElement(basePage.getWomenLink()).moveToElement(basePage.getTshirtsLink()).click().build().perform();
        //actions.moveToElement(basePage.getWomenLink()).moveToElement(basePage.getTshirtsLink()).click().perform();
    }

    @AfterTest
    public void tearDownTests() {
        logger.info("Tearing down {} test-class", this.getClass().getSimpleName());
        /*if (driver != null) {
            driver.quit();
        }*/
    }
}
