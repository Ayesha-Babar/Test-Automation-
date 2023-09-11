package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class RedirectionPage
{
    WebDriver driver;
    private By HereButton= By.xpath("//a[text()='here']");
    public RedirectionPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public void clickHere()
    {
        driver.findElement(HereButton).click();
    }

    public String GetCurrentURL()
    {
        // check the current url
        return driver.getCurrentUrl();
    }
}
