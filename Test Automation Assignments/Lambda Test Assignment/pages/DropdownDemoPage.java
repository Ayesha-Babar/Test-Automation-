package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemoPage
{
    WebDriver driver;
    private By SelectOption= By.id("select-demo");
    private By DaySelectedText=By.cssSelector("p.selected-value");
    private By MultiSelectOption=By.id("multi-select");
    private By FirstSelectedButton=By.xpath("//button[contains(text(),'First Selected')]");
    private By GetLastSelectedButton=By.xpath("//button[contains(text(),'Get Last Selected')]");
    private By DisplayFirstSelected=By.xpath("//span[@class='genderbutton']");
    private By DisplayLastSelected=By.xpath("//span[@class='groupradiobutton block break-words']");
    public DropdownDemoPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void SelectfromSelectOption(String option)
    {
        WebElement dropdownElement=driver.findElement(SelectOption);
        //dropdownElement.click();
        Select dropdown= new Select(dropdownElement);
        dropdown.selectByVisibleText(option);
    }


    public void SelectfromMultiSelectOption(String place)
    {
        WebElement dropdownElement = driver.findElement(MultiSelectOption);

        Select dropdown2= new Select(dropdownElement);
        dropdown2.selectByVisibleText(place);
    }
    public boolean GetSelectConfirmation()
    {
       String message= driver.findElement(DaySelectedText).getText();
        if(message.contains("Day selected :-"))
        {
            return true;
        }
        return false;
    }

    public void ClickFirstSelected()
    {
        driver.findElement(FirstSelectedButton).click();
    }

    public void ClickGetLastSelected()
    {
        driver.findElement(GetLastSelectedButton).click();
    }
    public String DisplayFirstSelectedOption()
    {
        return driver.findElement(DisplayFirstSelected).getText();
    }

    public String DisplayLastSelectedOption()
    {
        return driver.findElement(DisplayLastSelected).getText();
    }




}
