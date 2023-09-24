package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage
{
    private WebDriver driver;
    private By InputField=By.id("file");
    private By UploadMessage=By.id("error");



    public FileUploadPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void UploadFile(String absolutePathOfFile)
    {
        driver.findElement(InputField).sendKeys(absolutePathOfFile);
    }

    public boolean GetUploadConfirmation()
    {
         String message= driver.findElement(UploadMessage).getText();
         if(message.contains("File Successfully Uploaded"))
         {
             return true;
         }
         return false;
    }


}
