package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressPage
{
    private WebDriver driver;
    private By InputField= By.id("my_field");
    private By result= By.id("result");

    public KeyPressPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public void EnterText(String s)
    {
        driver.findElement(InputField).sendKeys();
    }

    public String GetResult()
    {
        return driver.findElement(result).getText();
    }

    public void enterPI()
    {
        EnterText(Keys.chord(Keys.ALT,"227")+"3.14");
    }
}
