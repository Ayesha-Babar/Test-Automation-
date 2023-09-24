package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonDemoPage
{
    private WebDriver driver;
    private By radioButtonMale= By.xpath("//input[@value='Male']");
    private By radioButtonFemale= By.xpath("//input[@value='Female']");
    private By GetValue_Button= By.id("buttoncheck");
    private By RadioMessageText=By.xpath("//p[contains(@class,'text-gray-900 text-size-15')]");
    private By disabledCheckbox= By.xpath("//input[@value='Checkbox3']");
    private By age= By.xpath("//input[@value ='5 - 15']");
    private By getvalueButton= By.xpath("//button[text()='Get values']");
    private By genderConfirmation= By.xpath("//span[@class='genderbutton']");
    private By ageConfirmation= By.xpath("//span[@class='groupradiobutton']");

    public RadioButtonDemoPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickFirstRadioButton()
    {
        List<WebElement> Male= driver.findElements(radioButtonMale);
        Male.get(0).click();
    }

    public String confirmationClick()
    {
      return driver.findElement(RadioMessageText).getText();
    }

    public boolean CheckDisabled()
    {
        WebElement checkbox3=driver.findElement(disabledCheckbox);
        if(checkbox3.isEnabled())
        {
            return false;
        }
        return true;
    }

    public void ClickAgeandGender()
    {
        List<WebElement> Male= driver.findElements(radioButtonMale);
        Male.get(1).click();

        driver.findElement(age).click();

    }

    public void clickgetValue()
    {
        driver.findElement(getvalueButton).click();
    }

    public String genderConfirmation()
    {
        return driver.findElement(genderConfirmation).getText();

    }

    public String ageconfirmation()
    {
        return driver.findElement(ageConfirmation).getText();
    }
    



}
