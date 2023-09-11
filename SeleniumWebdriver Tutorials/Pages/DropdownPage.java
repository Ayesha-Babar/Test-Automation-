package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.id;

public class DropdownPage
{
    private WebDriver driver;
    public DropdownPage(WebDriver driver)
    {
        this.driver=driver;
    }
    private By dropdown_Button= id("dropdown");
    public void selectfromdropdown(String option)
    {
        Select dropdown= new Select(driver.findElement(dropdown_Button));
        dropdown.selectByVisibleText(option);
        //finddropdown().selectByVisibleText(option);
    }
    public Select finddropdown()
    {
        return new Select(driver.findElement(dropdown_Button));

    }
    public List<String> getSelectedOptions()
    {
        List<WebElement>selectedOptions=finddropdown().getAllSelectedOptions();
        return selectedOptions.stream().map(e->e.getText()).collect(Collectors.toList());
    }

}
