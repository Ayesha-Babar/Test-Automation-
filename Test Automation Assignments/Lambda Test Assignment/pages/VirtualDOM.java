package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VirtualDOM {
    WebDriver driver;
    private By currentTimeBox = By.xpath("//h2[contains(@class,'text-size-30')]");

    public VirtualDOM(WebDriver driver) {
        this.driver = driver;
    }

    public String GetTime() {
        List<WebElement> Time = driver.findElements(currentTimeBox);
        return Time.get(0).getText();

    }

    public String Time() {
        // Create a DateFormat instance to format the time
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        // Get the current time
        Date currentTime = new Date();

        // Format the current time using the DateFormat
        String formattedTime = dateFormat.format(currentTime);

        // Print the formatted time
        System.out.println("Current Time: " + formattedTime);
        return formattedTime;
    }


public boolean ConfirmTime()
{
    if(Time()==GetTime())
    {
        return true;
    }
    return false;
}
}

