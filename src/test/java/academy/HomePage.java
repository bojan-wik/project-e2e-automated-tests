package academy;

import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

/**
 * Pomiędzy klasami 'Base' i 'HomePage' tworzę relację parent-child. Dzięki temu klasa 'HomePage' ma dostęp do wszystkich
 * metod klasy 'Base'
 */
public class HomePage extends Base {

    @Test
    public void openHomePage() throws IOException {
        driver = initializeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.quit();
    }
}
