package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Homepage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Basetest
{
    public  WebDriver driver;

    protected  Homepage homepage;



    @BeforeTest
    public  void setUp()
    {
        System.out.println("Setting up");
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emumba\\Documents\\WeatherShoppingAssignment_TA\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        //co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://weathershopper.pythonanywhere.com/");
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        homepage = new Homepage(driver);
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
        driver.get("https://weathershopper.pythonanywhere.com/");
    }

        /*@AfterClass
    public void tearDown()
    {
        driver.quit();
    }*/


}