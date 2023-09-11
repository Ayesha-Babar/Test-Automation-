package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class DownloadFilePage
{
    private WebDriver driver;
    private By DownloadFile_Button= By.xpath("//button[contains(text(),'Download File')]");


    public DownloadFilePage(WebDriver driver)
    {
        this.driver= driver;
    }

    public void clickDownloadFile()
    {
        driver.findElement(DownloadFile_Button).click();
    }

    public boolean downloadConfirmation(String downloadedFilePath)
    {
        File downloadedFile= new File(downloadedFilePath);
        if(downloadedFile.exists())
        {
            return true;
        }
        return false;
    }


}
