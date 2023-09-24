package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BootstrapDownloadProgressBarPage
{
    WebDriver driver;
    private By StartDownload_Button= By.id("dwnBtn");
    private By DownloadCompletedMessage= By.xpath("//p[text()='Download completed!']");
    public BootstrapDownloadProgressBarPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickStartDownload()
    {
        driver.findElement(StartDownload_Button).click();
    }

    public boolean DownloadConfirmation()
    {
        return driver.findElement(DownloadCompletedMessage).isDisplayed();
    }
}
