package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Ta klasa służy do przechowywania obiektów, które są wspólne dla całej aplikacji np. obiekty z sekcji header (buttony 'Contact us', 'Sign in'),
 * albo footer (pole newsletter). Z początku chciałem tworzyć osobne klasy dla tych obiektów ('FooterObjects.java' itd.), ale przeczytałem, że lepszą
 * praktyką jest stworzenie takiej klasy 'BasePageObjects' po której potem będą dziedziczyły wszystkie inne klasy z obiektami poszczególnych stron.
 * */
public class BasePageObjects {

    WebDriver driver;
    public BasePageObjects(WebDriver driver) {
        this.driver = driver;
    }

    By contactButtonLocator = By.id("contact-link");

    public WebElement getContactButton() { return driver.findElement(contactButtonLocator); }
}

/**
 * Żródła:
 * https://stackoverflow.com/questions/59901772/how-to-add-repeatable-sections-like-header-footer-with-all-page-classes-of-an-ap
 */
