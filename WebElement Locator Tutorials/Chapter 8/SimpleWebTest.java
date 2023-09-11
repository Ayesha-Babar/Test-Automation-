import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class SimpleWebTest {
    private WebDriver driver;

    @BeforeEach
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emumba\\Desktop\\git\\selenium4\\installation\\src\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void SearchDuckDuckGo() {
        // Load the page
        driver.get("https://duckduckgo.com/");

        // Enter search query
        WebElement SearchInputField = driver.findElement(By.xpath("//input[@name='q']"));
        SearchInputField.sendKeys("Giant Panda");

        // Click the search button
        WebElement SearchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        SearchButton.click();

        // Wait for results to appear (you can use WebDriverWait here)
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleContains("Giant Panda"));


        // Make sure each result contains the word Panda
        List<WebElement>resultLinks=  driver.findElements(By.xpath("//span[contains(text(),'Giant Panda')]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Giant Panda')]")));
        for(WebElement link:resultLinks)
        {
            assertTrue(resultLinks.getText().matches("(?i).*panda.*"));
        }
        // You can add your verification logic here
    }

   @AfterEach
    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
