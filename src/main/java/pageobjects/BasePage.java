package pageobjects;

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

    /**
     * Dobrą praktyką jest identyfikować zmienne, które nie powinny być dostępne spoza danej klasy i deklarować je jako private.
     * Potem te zmienne private można obudować w metody, które z kolei już mogą być dostępne na zewn., poprzez deklarowanie ich jako np. public.
     * JEST TO PRZYKŁAD ENCAPSULATION - JEDNEJ Z GŁÓWNYCH ZASAD OOP.
     * W tym przypadku zmienne typu 'By', które są locatorami deklaruję jako private,
     * a potem obudowuję je w metody, które zwracają mi już całe webelementy i są zadeklarowane jako public.
     * Tutaj chodzi np. o to, żeby ograniczyć dostęp do locatorów i nie pozwolić np. na pisanie 'driver.findElement(contactButtonLocator)' w testkejsach, bo to zła praktyka.
     */
    private final By contactButtonLocator = By.id("contact-link");
    private final By loginButtonLocator = By.xpath("//a[@class='login']");
    private final By searchBoxLocator = By.id("search_query_top");
    private final By searchButtonLocator = By.xpath("//button[@name='submit_search']");
    private final By womenLinkLocator = By.xpath("//a[@title='Women']");
    private final By tshirtsLinkLocator = By.xpath("//a[@title='T-shirts']");
    //private By productsListLocatorHomepage = By.xpath();
    private final By productsListLocator = By.xpath("//*[@id='center_column']/ul");
    private final By firstProductLocator = By.xpath("//h5[@itemprop='name'][1]");
    private final By newsletterEmailFieldLocator = By.id("newsletter-input");
    private final By newsletterSubmitButtonLocator = By.xpath("//button[@name='submitNewsletter']");
    private final By alertFailLocator = By.className("alert-danger");
    private final By alertSuccessLocator = By.className("alert-success");

    public WebElement getContactButton() { return driver.findElement(contactButtonLocator); }
    public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }
    public WebElement getSearchBox() { return driver.findElement(searchBoxLocator); }
    public WebElement getSearchButton() { return driver.findElement(searchButtonLocator); }
    public WebElement getWomenLink() { return driver.findElement(womenLinkLocator); }
    public WebElement getTshirtsLink() { return driver.findElement(tshirtsLinkLocator); }
    public WebElement getProductsList() { return driver.findElement(productsListLocator); }
    public WebElement getFirstProduct() { return driver.findElement(firstProductLocator); }
    /**
     * Poprzednia metoda (getLoginButton()) zwracała tylko WebElement login buttona. Potem w testcase wykonywałem na tym webelemencie click
     * i zawsze po tym następowało przejście do strony logowania i musiałem tworzyć obiekt klasy LoginPageObjects.
     * Teraz ten cały proces mam zawarty w metodzie clickLoginButton()
     */
    /*public LoginPage clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }*/
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
