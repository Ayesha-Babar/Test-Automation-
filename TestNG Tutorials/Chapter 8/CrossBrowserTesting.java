
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebDriverFactory {
    public static WebDriver createWebDriver(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emumba\\courses\\TestNG Tutorials\\untitled\\src\\main\\resources\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Emumba\\courses\\TestNG Tutorials\\untitled\\src\\main\\resources\\firefoxdriver-win64\\firefoxdriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        return driver;
    }
    public static class nestedClassForTesting{
            private WebDriver driver;

            @BeforeMethod
            @Parameters("browser")
            public void setUp(String browser) {
                driver = WebDriverFactory.createWebDriver(browser);
            }

            @Test
            public void testExample() {
                driver.get("https://example.com");
                WebElement element = driver.findElement(By.tagName("h1"));
                // Add your testing logic here
            }

            @AfterMethod
            public void tearDown() {
                if (driver != null) {
                    driver.quit();
                }
            }
        }

    }

}

