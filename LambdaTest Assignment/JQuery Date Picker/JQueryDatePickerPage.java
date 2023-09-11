package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void Select_FromDate()
    {
        driver.findElement(DesiredDateFrom).click();
    }

    public void clickTo()
    {
        driver.findElement(ToField).click();
    }

    public void Select_ToDate()
    {
        driver.findElement(DesiredDateTo).click();
    }

    public String GetText_From()
    {
        return driver.findElement(FromField).getText();

    }

    public String GetText_To()
    {
        return driver.findElement(ToField).getText();
    }


}
