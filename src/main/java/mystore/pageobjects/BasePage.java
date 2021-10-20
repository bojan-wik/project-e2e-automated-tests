package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Ta klasa służy do przechowywania obiektów, które są wspólne dla całej aplikacji np. obiekty z sekcji header (buttony 'Contact us', 'Sign in'),
 * albo footer (pole newsletter). Z początku chciałem tworzyć osobne klasy dla tych obiektów ('Footer.java' itd.), ale przeczytałem, że lepszą
 * praktyką jest stworzenie takiej klasy bazowej, po której potem będą dziedziczyły wszystkie inne klasy z pageobjects.
 * */
public class BasePage {
    /**
     * Tutaj wykonuję te same kroki, które wcześniej robiłem w każdej klasie z pageobjects - tworzę obiekt WebDriver i konstruktor klasy.
     * Różnica polega na tym, że teraz te kroki są wykonywane TYLKO tutaj, a WebDriver jest zasilany za pośrednictwem child-class i keyworda super().
     */
    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    By contactButtonLocator = By.id("contact-link");
    By loginButtonLocator = By.xpath("//a[@class='login']");
    By newsletterEmailFieldLocator = By.id("newsletter-input");
    By newsletterSubmitButtonLocator = By.xpath("//button[@name='submitNewsletter']");
    By alertFailLocator = By.className("alert-danger");
    By alertSuccessLocator = By.className("alert-success");

    public WebElement getContactButton() { return driver.findElement(contactButtonLocator); }

    /*public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }*/
    /**
     * Poprzednia metoda (getLoginButton()) zwracała tylko WebElement login buttona. Potem w testcase wykonywałem na tym webelemencie click
     * i zawsze po tym następowało przejście do strony logowania i musiałem tworzyć obiekt klasy LoginPageObjects.
     * Teraz ten cały proces mam zawarty w metodzie clickLoginButton()
     */
    public LoginPage clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }

    public WebElement getNewsletterEmailField() { return driver.findElement(newsletterEmailFieldLocator); }
    public WebElement getNewsletterSubmitButton() { return driver.findElement(newsletterSubmitButtonLocator); }
    public WebElement getAlertFail() { return driver.findElement(alertFailLocator); }
    public WebElement getAlertSuccess() { return driver.findElement(alertSuccessLocator); }
}

/**
 * Żródła:
 * https://stackoverflow.com/questions/59901772/how-to-add-repeatable-sections-like-header-footer-with-all-page-classes-of-an-ap
 * https://devqa.io/page-object-framework-java-webdriver/
 */
