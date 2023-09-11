package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GeoLocationClass
{
   ChromeDriver driver;
    @BeforeMethod
    public void setUp()
    {
       WebDriverManager.edgedriver().setup();
       // System.setProperty("webdriver.chrome.driver","C:\\Users\\Emumba\\Desktop\\git\\selenium4\\installation\\src\\test\\java\\chromedriver-win64\\chromedriver.exe");
        driver= new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Geolocation()
    {
        Map coordinates= new HashMap()
        {{
            put("latitude",33.6573);
            put("longitude",73.0571544);
            put("accuracy",1);
        }};


        Map<String, Object> stringObjectMap = driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        driver.get("https://www.where-am-i.co/");
    }
    @Test
    public void geoLocationDevTools()
    {
        DevTools devtools= new DevTools();
        devtools.createSession();
        devtools.send(Emulation.setGeolocationOverride(Optional.of(52.5043),
                Optional.of(13.4501),
                Optional.ofNullable(1)));
        driver.get("https://mylocation.org/");
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
