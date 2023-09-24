package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AjaxFormSubmitPage
{
    private WebDriver driver;
    private By NameField= By.id("title");
    private By messageField= By.id("description");
    private By submit_button= By.id("btn-submit");
    private By SubmitConfirmationMessage= By.id("submit-control");



    public AjaxFormSubmitPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void EnterName(String name)
    {
        driver.findElement(NameField).sendKeys(name);
    }

    public void EnterMessage(String message)
    {
        driver.findElement(messageField).sendKeys(message);
    }

    public void ClickSubmit()
    {
        driver.findElement(submit_button).click();
    }

    public boolean SubmitConfirmation()
    {
        // check if Ajax processing message is displayed
        return driver.findElement(SubmitConfirmationMessage).isDisplayed();

    }

}
