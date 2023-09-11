package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class JavascriptAlerts
{
    private WebDriver driver;
   private By JavaScriptsAlerts_ClickMe= By.xpath("//*[@id=\"__next\"]/section[2]/div/div/div/div[1]/p/button");
   private By ConfirmBox_ClickMe= By.xpath("//*[@id=\"__next\"]/section[2]/div/div/div/div[2]/div/p[1]/button");
   private By ConfirmBox_Message=By.id("confirm-demo");

   private By PromptBox_ClickMe= By.xpath("//*[@id=\"__next\"]/section[2]/div/div/div/div[2]/div/p[1]/button");
   private By PromptBox_Message= By.id("prompt-demo");


  public JavascriptAlerts(WebDriver driver)
  {
      this.driver= driver;
  }

   public void triggerJavaScriptsAlerts()
   {
       driver.findElement(JavaScriptsAlerts_ClickMe).click();
   }
    public void JavaScript_AcceptAlert()
    {
        driver.switchTo().alert().accept();
    }

    public String Javascript_AlertText()
    {
        return driver.switchTo().alert().getText();

    }

    public  void triggerConfirmBox()
    {
        driver.findElement(ConfirmBox_ClickMe).click();
    }
    public void ConfirmBox_Accept()
    {
        driver.switchTo().alert().accept();
    }
    public void ConfirmBox_Dismiss()
    {
        driver.switchTo().alert().dismiss();
    }

    public String ConfirmBoxtext()
    {
        return driver.switchTo().alert().getText();
    }

    public String ConfirmBoxMessage()
    {
        return driver.findElement(ConfirmBox_Message).getText();
    }


    public void triggerPromptBox()
    {
        driver.findElement(PromptBox_ClickMe).click();
    }

  public void PromptBox_InputText(String text)
  {
      driver.switchTo().alert().sendKeys(text);
  }

  public String PromptBox_Message()
  {
      return driver.findElement(PromptBox_Message).getText();
  }


}
