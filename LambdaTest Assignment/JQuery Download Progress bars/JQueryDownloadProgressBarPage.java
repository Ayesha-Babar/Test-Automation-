package Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JQueryDownloadProgressBarPage
{
    private WebDriver driver;
    private By StartDownload_Button= By.id("downloadButton");
    private By DialogBox= By.xpath("//div[@role='dialog']");
    private By CompleteText= By.xpath("//div[@class='progress-label']']");

    public JQueryDownloadProgressBarPage (WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickStartDownload()
    {
        WebElement dialog= driver.findElement(DialogBox);
        driver.findElement(StartDownload_Button).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(dialog));

    }

    public boolean WaitForProgressBarTocomplete()
    {

        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        WebElement CompleteMessage= driver.findElement(CompleteText);
        var until = wait2.until(ExpectedConditions.visibilityOf(CompleteMessage));
        return CompleteMessage.isDisplayed();
    }

}
