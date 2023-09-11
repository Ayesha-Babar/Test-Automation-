package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavascriptAlertsPage
{
    private WebDriver driver;
    private By triggerAlertButton= By.xpath("//button[contains(text(),'Click for JS Alert')]");
    public JavascriptAlertsPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void triggerAlert()
    {
        driver.findElement(triggerAlertButton).click();
    }

    public void acceptAlert()
    {
        //alert is not a webelement so use switch command
        driver.switchTo().alert().accept();
    }


}
