package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicDataLoadingPage
{
    WebDriver driver;
    private By GetRandomUser=By.xpath("//button[@id='save']");
    private By image= By.xpath("//div[@class='p-20']//img");
    private By DataBox= By.xpath("//div[@id='loading']");
    public DynamicDataLoadingPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickGetRandomUser()
    {
        driver.findElement(GetRandomUser).click();
    }

    public boolean isBoxDisplayed()
    {
        return driver.findElement(DataBox).isDisplayed();
    }
}
