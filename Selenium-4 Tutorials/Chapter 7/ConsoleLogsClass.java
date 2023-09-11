package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConsoleLogsClass
{
    ChromeDriver driver;

    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Emumba\\Desktop\\git\\selenium4\\installation\\src\\test\\java\\chromedriver-win64\\chromedriver.exe");
       // WebDriverManager.Chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void viewBrowserConsoleLogs()
    {
        //get the devtools and create a session
       DevTools devtools= driver.getDevTools();
       devtools.createSession();

       // enable the console logs
        devtools.send(Log.enable());

        // add a listener for console logs
        devtools.addListener(Log.entryAdded(),logEntry->
        {
            System.out.println("--------");
            System.out.println("Level: "+logEntry.getLevel());
            System.out.println("text: "+logEntry.getText());
            System.out.println("broken url: "+logEntry.getUrl());

        });

        // load the AUT
        driver.get("https://the-internet.herokuapp.com/broken_images");
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
