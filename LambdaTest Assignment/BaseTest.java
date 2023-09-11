package Base;
import Pages.Homepage;

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

import java.util.List;

public class BaseTest{
    public  WebDriver driver;

   protected  Homepage homepage1;



    @BeforeTest
    public  void setUp()
    {
        System.out.println("Setting up");
        WebDriverManager.chromedriver().setup();
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emumba\\UI Test Automation Assignment\\Assignment\\src\\main\\resources\\new chromedriver\\chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        //co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.lambdatest.com/selenium-playground/");
        //WebDriverWait wait = new WebDriverWait(driver, 20);
         homepage1 = new Homepage(driver);
        //print the list of webelements to be tested
        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println("This number of elements to be tested on the homepage are: " + list.size());

        //print the title of the page
        String title = driver.getTitle();
        System.out.println(title);

    }


    @BeforeMethod
    public void GoHome()
    {
        driver.get("https:www.lambdatest.com/selenium-playground/");
    }
    /*@AfterClass
    public void tearDown()
    {
        driver.quit();
    }*/
}
