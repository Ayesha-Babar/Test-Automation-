package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;

public class Homepage {

    private WebDriver driver;
    private By temperature = By.xpath("//span[@id='temperature']");
    private By BuyMoisturizers_button= By.xpath("//button[text()='Buy moisturizers']");
    private By BuySunscreens_button= By.xpath("//button[text()='Buy sunscreens']");
    public Homepage(WebDriver driver)
    {
        this.driver= driver;
    }

    public String GetTemperature()
    {
        return (driver.findElement(temperature).getText());
    }


    public MoisturizerPage clickBuyMoisturizers()
    {
        driver.findElement(BuyMoisturizers_button).click();
        return new MoisturizerPage(driver);
    }

    public String ValidateURL()
    {
        return driver.getCurrentUrl();
    }


    public SunscreenPage clickBuySunscreen()
    {
        driver.findElement(BuySunscreens_button).click();
        return new SunscreenPage(driver);
    }


}
