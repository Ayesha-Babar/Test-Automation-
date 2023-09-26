package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JQueryDatePickerPage
{
    WebDriver driver;
    private By FromField= By.id("from");
    private By ToField= By.id("to");
    // whatever date one intends to choose
    // change the number in text()
    private By DesiredDateFrom= By.xpath("//a[text()='15']");
    private By DesiredDateTo= By.xpath("//a[text()='26']");

    public JQueryDatePickerPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickFrom()
    {
        driver.findElement(FromField).click();
    }

    public void Select_FromDate(String date)
    {
        WebElement from=driver.findElement(FromField);

        String script = "arguments[0].setAttribute('value', '" + date + "')";
        ((JavascriptExecutor) driver).executeScript(script, from);

    }

    public void clickTo()
    {
        driver.findElement(ToField).click();
    }

    public void Select_ToDate(String date)
    {
        WebElement To= driver.findElement(ToField);
        String script = "arguments[0].setAttribute('value', '" + date + "')";
        ((JavascriptExecutor) driver).executeScript(script, To);

    }

    public String GetText_From()
    {
       String text= driver.findElement(FromField).getText();
       return text;

    }

    public String GetText_To()
    {
        String text= driver.findElement(ToField).getText();
        return text;
    }


}
