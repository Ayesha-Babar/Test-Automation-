package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentSuccessPage
{
    WebDriver driver;
    private By confirmationText= By.xpath("//p[@class='text-justify']");
    public PaymentSuccessPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public String IsconfirmationTextDisplayed()
    {
        return driver.findElement(confirmationText).getText();
    }
}
