package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class JQueryDownloadProgressBarPage
{
    private WebDriver driver;
    private By StartDownload_Button= By.id("downloadButton");
    private By DialogBox= By.xpath("//div[@role='dialog']");
    private By CompleteText= By.xpath("//div[text()='Complete!']");

    public JQueryDownloadProgressBarPage (WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickStartDownload()
    {

        driver.findElement(StartDownload_Button).click();


    }

    public boolean WaitForProgressBarTocomplete()
    {

       WebElement dialogBox= driver.findElement(DialogBox);

       WebElement CompleteMessage= driver.findElement(CompleteText);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       if( dialogBox.isDisplayed())
       {
           return true;
       }
       return false;
    }

}
