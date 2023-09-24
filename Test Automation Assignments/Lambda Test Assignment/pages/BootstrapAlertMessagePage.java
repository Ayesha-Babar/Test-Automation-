package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BootstrapAlertMessagePage
{
    private WebDriver driver;
    private By AutoclosableSuccessMessage_button=By.xpath("//button[text()='Autoclosable Success Message']");
    private By AutoclosableSuccessMessage_Alert=By.xpath("//div[contains(@class, 'alert-success-auto') and contains(text(), 'Autocloseable success message.')]");
    private By NormalSuccessmessage_button= By.xpath("//button[text()='Normal Success Message']");
    private By NormalSuccessAlert= By.xpath("//div[contains(@class, 'alert-success') and contains(text(), 'Normal success message.')]");
    private By Close=By.xpath("//a[@aria-label='close']");
    private By AutoclosableInfoMessage_button=By.xpath("//button[text()='Autoclosable Info Message']");
    private By AutoclosableInfoAlert=By.xpath("//div[contains(@class, 'alert-info-auto') and contains(text(), 'Autocloseable info message.')]");
    private By NormalInfoMessage_button= By.xpath("//button[text()='Normal Info Message']");
    private By NormalInfoAlert= By.xpath("//div[contains(@class, 'alert-info-auto') and contains(text(), 'Autocloseable info message.')]");
    //private By NormalInfoAlertClose= By.xpath("//a[@aria-label='close']");

    public BootstrapAlertMessagePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void clickAutoclosableSuccessMassage_button()
    {
        driver.findElement(AutoclosableSuccessMessage_button).click();
    }
    public boolean AutoclosableSuccessAlertDisplay()
    {
        WebElement Alert= driver.findElement(AutoclosableSuccessMessage_Alert);
        return Alert.isDisplayed();
    }

    public void clickNormalSuccess()
    {
        driver.findElement(NormalSuccessmessage_button).click();
    }

    public boolean NormalSuccessAlertDisplay()
    {
        WebElement Alert1= driver.findElement(NormalSuccessAlert);
        return Alert1.isDisplayed();
    }

    public void clickclose()
    {
        driver.findElement(Close).click();
    }

    public void ClickAutoclosableInfo()
    {
        driver.findElement(AutoclosableInfoMessage_button).click();
    }

    public boolean AutoclosableInfoAlertDisplay()
    {
        WebElement Alert3= driver.findElement(AutoclosableInfoAlert);
        return Alert3.isDisplayed();
    }


    public void clickNormalInfo()
    {
        driver.findElement(NormalInfoMessage_button).click();
    }


    public boolean NormalInfoAlertDisplay()
    {
        WebElement Alert4= driver.findElement(NormalInfoAlert);
        return Alert4.isDisplayed();
    }






}
