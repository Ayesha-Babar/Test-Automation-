package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimpleFormDemoPage  {

    static WebDriver driver;
    private By EnterMessageField= By.id("user-message");
    private By displayMessageOutput=By.id("message");
    private By displaySumOutput=By.id("addmessage");
    private By FirstValueField=By.id("sum1");
    private By SecondValueField= By.id("sum2");
    private By GetCheckedValueButton= By.id("showInput");
    private By GetSumButton=By.xpath("//button[contains(text(),'Get Sum')]");

    public SimpleFormDemoPage(WebDriver driver)
    {
        this.driver= driver;
    }


    // inspect single input and Two input fields

     public void EnterMessage(String message)
     {
         driver.findElement(EnterMessageField).sendKeys(message);
     }
      public void clickGetCheckedValue()
      {
          driver.findElement(GetCheckedValueButton).click();
      }

     public void EnterFirstValue(int value)
     {
         driver.findElement(FirstValueField).sendKeys(String.valueOf(value));
     }

     public void EnterSecondValue(int value )
     {
         driver.findElement(SecondValueField).sendKeys(String.valueOf(value));

     }

     public void clickGetSum()
      {
          driver.findElement(GetSumButton).click();
      }

      public String getDisplayMessageOutput()
      {
         return driver.findElement(displayMessageOutput).getText();
      }

      public int getSumDisplayed()
      {
        String sumText=  driver.findElement(displaySumOutput).getText();
        return Integer.parseInt(sumText);
      }




}
