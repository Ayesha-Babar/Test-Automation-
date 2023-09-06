package Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/*import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;*/
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import Pages.HomePage;

import java.util.List;

public class BaseTest{
    public static WebDriver driver;
   protected static HomePage homepage;

    @BeforeClass
    public static void setUp()
    {
        System.out.println("Setting up");
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emumba\\courses\\Selenium webdriver Tutorials\\untitled\\src\\main\\resources\\new chromedriver\\chromedriver.exe");
        ChromeOptions co = new ChromeOptions();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        //WebDriverWait wait = new WebDriverWait(driver, 20);
        homepage= new HomePage(driver);

        //print the list of webelements to be tested
        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println("This number of elements to be tested on the homepage are: " + list.size());

        //print the title of the page
        String title = driver.getTitle();
        System.out.println(title);


    }

    /*@AfterClass
    public void teardown()
    {
        driver.quit();
    }*/




}

