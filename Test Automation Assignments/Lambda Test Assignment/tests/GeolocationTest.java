package tests;

import pages.GeolocationTestingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class GeolocationTest extends BaseTest
{
    WebDriver driver;
    private By place_field= By.id("place");
    private By find_button= By.id("btnfind");
    private By latitude= By.id("lat");
    private By longitude= By.id("lng");
    public GeolocationTest(WebDriver driver) {
        this.driver = driver;
    }


    @Test
    public void Geolocation_DevTools()
    {
        GeolocationTestingPage page = homepage1.clickGeolocation();


        DevTools devtools;
        devtools = ((ChromeDriver) driver).getDevTools();
        devtools.createSession();
        devtools.send(Emulation.setGeolocationOverride(Optional.of(33.7233),
                Optional.of(73.0435),
                Optional.of(1)));
        driver.get("https://www.latlong.net/");
        driver.findElement(place_field).sendKeys("Islamabad, Pakistan");
        driver.findElement(find_button).click();

        assertEquals(driver.findElement(latitude).getText(),page.getLatitude());
        assertEquals(driver.findElement(longitude).getText(),page.getLongitude());

    }
   /* @Test
    public void testGeolocation(){
        @Test

        public void coordinates_ExecuteCdpCommand() {
            GeolocationTestingPage page = homepage1.clickGeolocation();
            Map<String, Object> coordinatesMap = new HashMap<>();
            coordinatesMap.put("latitude", 33.7233);
            coordinatesMap.put("longitude", 73.0435);
            coordinatesMap.put("accuracy", 1);

            //devTools.send(Network.emulateNetworkConditions(true, 100, 1000, 1000, ResourceType.NONE));
            // devTools.send(Network.emulateGeolocation(33.7233, 73.0435, 1));
            driver.executeCdpCommand("Emulation.setGeolocationOverride",
                    coordinatesMap);
            driver.get("https://www.where-am-i.co/");
            driver.manage().window().maximize();
            assertTrue( page.TextMatch());

        }*/
}