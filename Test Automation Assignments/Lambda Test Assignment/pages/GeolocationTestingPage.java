package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;

public class GeolocationTestingPage {
    private WebDriver driver;
    private By Latitude= By.xpath("//p[text()='Latitude:']//span");
    private By Longitude= By.xpath("//p[text()='longitude:']//span");
    private By Country= By.xpath("//p[text()='Country Code:']//span");

    private DevTools devTools;

    public GeolocationTestingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLongitude()
    {
       return driver.findElement(Longitude).getText();
    }

    public String getLatitude()
    {
        return driver.findElement(Latitude).getText();
    }

    /*public boolean TextMatch()
    {
        if(driver.findElement(Latitude).getText()=="33.7233" && driver.findElement(Longitude).getText()=="73.0435" && driver.findElement(Country).getText()=="Pakistan")
        {
            return true;
        }
        return false;

    }*/





}