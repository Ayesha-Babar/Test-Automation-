package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BootstrapDatePickerPage
{
    WebDriver driver;
    private By Birthday= By.xpath("//input[@id='birthday']");
    private By startDate= By.xpath("//input[@placeholder='Start date']");
    private By endDate= By.xpath("//input[@placeholder='End date']");
    public BootstrapDatePickerPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void EnterText(String date)
    {
        driver.findElement(Birthday).click();
        driver.findElement(Birthday).sendKeys(date);
    }

    public void EnterDate(String startdate, String enddate)
    {
        driver.findElement(startDate).sendKeys(startdate);
        driver.findElement(endDate).sendKeys(enddate);
    }

    public String TextConfirmation()
    {
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        return driver.findElement(Birthday).getText();
    }

    public String StartDateConfirmation()
    {
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        return driver.findElement(startDate).getText();
    }

    public String EndDateConfirmation()
    {
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        return driver.findElement(endDate).getText();
    }
}
