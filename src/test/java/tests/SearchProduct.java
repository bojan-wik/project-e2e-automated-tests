package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.BasePage;

import java.io.IOException;

/**
 * Assignment 3 - Automate 'Search Product' functionality of an e-commerce website
 * Test Case 1- Automate 'Search Product' Functionality of an e-commerce website with Selenium
 * Steps to Automate:
 * 1. Open link http://automationpractice.com/index.php - done
 * 2. Move your cursor over Women's link. - done
 * 3. Click on sub menu 'T-shirts' - done
 * 4. Get Name/Text of the first product displayed on the page. - done
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
        // 1. Open link http://automationpractice.com/index.php
        driver.get(properties.getProperty("url"));
        logger.info("Home page accessed");
        basePage = new BasePage(driver);
        actions = new Actions(driver);
    }

    @Test
    public void testCase1() {
        // 2. Move your cursor over Women's link.
        // 3. Click on sub menu 'T-shirts'
        actions.moveToElement(basePage.getWomenLink()).moveToElement(basePage.getTshirtsLink()).click().build().perform();
        logger.info("T-shirt page accessed");
        // 4. Get Name/Text of the first product displayed on the page.
        String firstProductName = basePage.getFirstProductNotHomepage().getText().trim();
        logger.info("Product list -> first product found: {}", firstProductName);
        // 5. Now enter the same product name in the search bar present on top of page and click search button.
        actions.moveToElement(basePage.getSearchBox()).click().sendKeys(firstProductName).
                moveToElement(basePage.getSearchButton()).click().build().perform();
    }

    @AfterTest
    public void tearDownTests() {
        logger.info("Tearing down {} test-class", this.getClass().getSimpleName());
        /*if (driver != null) {
            driver.quit();
        }*/
    }
}
