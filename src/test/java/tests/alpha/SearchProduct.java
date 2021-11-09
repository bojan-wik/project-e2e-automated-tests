package tests.alpha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

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

public class SearchProduct {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.home") + "\\IdeaProjects\\project-e2e-automated-tests\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://automationpractice.com/index.php");

        WebElement getWomenLink = driver.findElement(By.xpath("//a[@title='Women']"));
        WebElement getTshirtsLink = driver.findElement(By.xpath("//a[@title='T-shirts']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(getWomenLink).moveToElement(getTshirtsLink).click().build().perform();

        // 4. Get Name/Text of the first product displayed on the page
        By productListLocator = By.xpath("//*[@id='center_column']/ul");
        By firstProductLocator = By.xpath("//h5[@itemprop='name'][1]");
        WebElement getProductList = driver.findElement(productListLocator);
        WebElement getFirstProduct = getProductList.findElement(firstProductLocator);
        String firstProductName = getFirstProduct.getText().trim();
        System.out.println(firstProductName);

        // 5. Now enter the same product name in the search bar present on top of page and click search button.
        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@name='submit_search']"));
        actions.moveToElement(searchBox).click().sendKeys(firstProductName).moveToElement(searchButton).click().
                build().perform();

        // 6. Validate that same product is displayed on searched page with same details which were displayed on T-Shirt's page.
        WebElement getSearchedProductList = driver.findElement(productListLocator);
        WebElement getFirstSearchedProduct = getSearchedProductList.findElement(firstProductLocator);
        String firstSearchedProductName = getFirstSearchedProduct.getText().trim();
        System.out.println(firstSearchedProductName);
        Assert.assertEquals(firstSearchedProductName, firstProductName);

        // możliwa dodatkowa walidacja:
        // a) navigation: home -> search ?
        // b) title: SEARCH  "FADED SHORT SLEEVE T-SHIRTS" ?

        //driver.quit();
    }
}
