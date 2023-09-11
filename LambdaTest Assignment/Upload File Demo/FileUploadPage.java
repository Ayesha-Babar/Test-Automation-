package Pages;

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

    public String GetUploadConfirmation()
    {
          return driver.findElement(UploadMessage).getText();
    }


}
