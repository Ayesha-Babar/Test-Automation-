package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BootstrapModalPage
{
    WebDriver driver;

    public BootstrapModalPage(WebDriver driver)
    {
        this.driver=driver;
    }
   // private By LaunchSingleModal= By.xpath("//button[text()='Launch Modal' and @data-target='#myModal']");
    private By LaunchModalButton= By.xpath("//button[text()='Launch Modal' ]");
    List<WebElement> launchButton= driver.findElements(LaunchModalButton);
    private By LaunchMultipleModal=By.xpath("//button[@data-target='#myMultiModal']");
    private By LaunchSecondMultiModal= By.xpath("//button[@data-target='#mySecondModal']");
    private By modalcontentBody= By.xpath("//div[@class='modal-content']//div[@class='modal-body']//p");
    //private By save_button=By.xpath("//button[text()='Save Changes']");
    //WebElement SaveButtons= (WebElement) driver.findElements(save_button);
    WebElement modalContainer= driver.findElement(By.className("modal-dialog"));
    WebElement modalContentBody= modalContainer.findElement(modalcontentBody);



    public void clicklaunchButton (int index)
    {
        launchButton.get(index-1).click();

    }
    public String GetcontentFirstModal()
    {
        WebDriverWait wait= new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));


        return modalContentBody.getText();
    }

    public void accept()
    {
        WebElement acceptButton= modalContainer.findElement(By.xpath(".//button[contains(text(),'Save Changes"));
        acceptButton.click();;
    }

    public void ClickMultipleModal()
    {
        driver.findElement(LaunchMultipleModal).click();
    }

    public void ClickSecondLaunchModal()
    {
        driver.findElement(LaunchSecondMultiModal).click();
    }
}
