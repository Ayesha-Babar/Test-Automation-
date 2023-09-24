package tests;

import org.testng.annotations.*;
import pages.Homepage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class BaseTest{
    public  WebDriver driver;

   protected  Homepage homepage1;

    @BeforeSuite
    public  void setUp() {
        System.out.println("Setting up");
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emumba\\UI Test Automation Assignment\\Assignment\\src\\main\\resources\\new chromedriver\\chromedriver.exe");

    }


    @BeforeMethod
    public void beforemethod()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homepage1 = new Homepage(driver);

        driver.get("https://www.lambdatest.com/selenium-playground/");


        //print the list of webelements to be tested
        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println("This number of elements to be tested on the homepage are: " + list.size());

        //print the title of the page
        String title = driver.getTitle();
        System.out.println(title);

    }


    /* @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }*/


}
