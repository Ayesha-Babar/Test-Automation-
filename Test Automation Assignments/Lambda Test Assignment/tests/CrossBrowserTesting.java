package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class CrossBrowserTesting
{
    public static WebDriver createWebDriver(String browser)
    {
        WebDriver driver;
        switch(browser.toLowerCase())
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver","C:\\Users\\Emumba\\UI Test Automation Assignment\\Assignment\\src\\main\\resources\\new chromedriver\\chromedriver.exe");
                driver= new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","C:\\Users\\Emumba\\UI Test Automation Assignment\\Assignment\\src\\main\\resources\\geckodriver.exe");
                driver= new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","C:\\Users\\Emumba\\UI Test Automation Assignment\\Assignment\\src\\main\\resources\\msedgedriver.exe");
                driver= new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: "+browser);


        }
        return driver;

    }

    public static class nestedClassForTesting
    {
       private WebDriver driver;

        @BeforeMethod
        @Parameters("browser")
        public void setup(String browser)
        {
            driver=CrossBrowserTesting.createWebDriver(browser);
        }

        @Test
        public void testExample()
        {
            driver.get("https://www.lambdatest.com/selenium-playground/");

            List<WebElement> list = driver.findElements(By.tagName("a"));
            System.out.println("This number of elements to be tested on the homepage are: " + list.size());

        }

    }






}
