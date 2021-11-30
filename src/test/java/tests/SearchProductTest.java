package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.BasePage;

import java.io.IOException;

/**
 * Assignment 3 - Automate 'Search Product' functionality of an e-commerce website
 * Test Case 1- Automate 'Search Product' Functionality of an e-commerce website with Selenium
 * Steps to Automate:
 * 1. Open link http://automationpractice.com/index.php
 * 2. Move your cursor over Women's link.
 * 3. Click on sub menu 'T-shirts'
 * 4. Get Name/Text of the first product displayed on the page.
 * 5. Now enter the same product name in the search bar present on top of page and click search button.
 * 6. Validate that same product is displayed on searched page with same details which were displayed on T-Shirt's page.
 */

public class SearchProductTest extends TestBase {

    BasePage basePage;
    Actions actions;
    String firstProductName;
    String firstSearchedProductName;

    @BeforeTest
    public void setUpTests() throws IOException {
        logger.info("Setting up test-class: {}", this.getClass().getSimpleName());
        driver = initializeDriver();
        // 1. Open link http://automationpractice.com/index.php
        driver.get(properties.getProperty("url"));
        logger.info("Home page accessed");
        basePage = new BasePage(driver);
        actions = new Actions(driver);
    }

    @Test(priority = 0)
    public void openWomenTshirtsPage() {
        // 2. Move your cursor over Women's link.
        // 3. Click on sub menu 'T-shirts'
        actions.moveToElement(basePage.getWomenLink()).moveToElement(basePage.getTshirtsLink()).click().build().perform();
        Assert.assertTrue((driver.getTitle().toLowerCase()).contains("t-shirts"));
        logger.info("T-shirt page accessed");
    }

    @Test(priority = 1)
    public void verifyThatMinOneProductIsDisplayedAndGetItsName() {
        // 4. Get Name/Text of the first product displayed on the page.
        firstProductName = basePage.getFirstProduct().getText().trim();
        Assert.assertFalse(firstProductName.isEmpty());
        logger.info("Product list -> first product found: {}", firstProductName);
    }

    @Test(priority = 2)
    public void searchTheProductViaSearchBar() {
        // 5. Now enter the same product name in the search bar present on top of page and click search button.
        actions.moveToElement(basePage.getSearchBox()).click().sendKeys(firstProductName).
                moveToElement(basePage.getSearchButton()).click().build().perform();
        Assert.assertTrue((driver.getTitle().toLowerCase()).contains("search"));
        logger.info("Search results page accessed");
    }

    @Test(priority = 3)
    public void verifyThatTheSameProductIsDisplayedOnSearchResults() {
        // 6. Validate that same product is displayed on searched page with same details which were displayed on T-Shirt's page.
        firstSearchedProductName = basePage.getFirstProduct().getText().trim();
        Assert.assertFalse(firstProductName.isEmpty());
        logger.info("Search results list -> first product found: {}", firstSearchedProductName);
        Assert.assertEquals(firstSearchedProductName, firstProductName);
        logger.info("The same product is displayed on Search results page with same name which was displayed on T-Shirt's page");
    }

    @AfterTest
    public void tearDownTests() {
        logger.info("Tearing down test-class: {}", this.getClass().getSimpleName());
        if (driver != null) {
            driver.quit();
        }
    }
}
