package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FileDownloadPage
{
    WebDriver driver;
    private By textbox=By.id("textbox");
    private By CharactersRemainingText= By.id("textarea_feedback");
    private By GenerateFile_Button= By.id("create");
    private By download_link=By.id("link-to-download");
    public FileDownloadPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void Entertext(String message)
    {
        driver.findElement(textbox).sendKeys(message);
    }

    public boolean CharactersRemainingMessage()
    {
       return driver.findElement(CharactersRemainingText).isDisplayed();
    }

    public String GetCharactersRemainingMessage()
    {
        return driver.findElement(CharactersRemainingText).getText();

    }

    public void clickGenerateFileButton()
    {
        driver.findElement(GenerateFile_Button).click();
    }

    public void clickDownloadFileLink()
    {
        driver.findElement(download_link).click();
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


