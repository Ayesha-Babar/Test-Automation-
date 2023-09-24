package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class JavascriptAlerts
{
    private  WebDriver driver;
    public JavascriptAlerts(WebDriver driver) {
        this.driver = driver;
    }

    private By ClickMe_Button= By.xpath("//button[text()='Click Me']");

   private By ConfirmBox_Message=By.id("confirm-demo");

   private By PromptBox_ClickMe= By.xpath("//*[@id=\"__next\"]/section[2]/div/div/div/div[2]/div/p[1]/button");
   private By PromptBox_Message= By.id("prompt-demo");

   private By ClickMeButton= By.xpath("//button[text()='Click Me']");





   public void triggerJavaScriptsAlerts()
   {
       List<WebElement>ClickmeButtons= driver.findElements(ClickMe_Button);
       ClickmeButtons.get(0).click();
   }
    public void AcceptAlert()
    {
        driver.switchTo().alert().accept();
    }

    public String AlertText()
    {
        return driver.switchTo().alert().getText();

    }

    public  void triggerConfirmBox()
    {
        List<WebElement>ClickmeButtons= driver.findElements(ClickMe_Button);
        ClickmeButtons.get(1).click();
    }

    public void AlertDismiss()
    {
        driver.switchTo().alert().dismiss();
    }



    public String ConfirmBoxMessage()
    {
        return driver.findElement(ConfirmBox_Message).getText();
    }


    public void triggerPromptBox() {
        List<WebElement> ClickmeButtons = driver.findElements(ClickMe_Button);
        ClickmeButtons.get(2).click();
    }

  public void PromptBox_InputText(String t)
  {
      driver.switchTo().alert().sendKeys(t);
  }

  public String PromptBox_Message()
  {
      return driver.findElement(PromptBox_Message).getText();
  }


}
