package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CheckboxDemoPage
{
    static WebDriver driver;
    public CheckboxDemoPage(WebDriver driver)
    {
        this.driver=driver;
    }
    // all checkboxes can be accessed
    private By checkboxesLocator= By.cssSelector("input[@type='checkbox']");
    private By CheckedMessage=By.cssSelector("div#txtAge");
    // Find all checkboxes
    List<WebElement> checkboxes = driver.findElements(checkboxesLocator);
    public void checkCheckboxByIndex(int index)
    {

        // Check if the index is within bounds
        if (index >= 1 && index <= checkboxes.size()) {
            // Check the checkbox at the specified index
            checkboxes.get(index - 1).click();
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
    }

    public boolean DisplayCheckedMessage()
    {
         return driver.findElement(CheckedMessage).isDisplayed();

    }
    public String CheckedMessageText()
    {
        return driver.findElement(CheckedMessage).getText();
    }
    public boolean CheckSelected(int index)
    {
        return checkboxes.get(index - 1).isSelected();
    }

    public boolean CheckEnabled(int index)
    {
        return checkboxes.get(index-1).isEnabled();
        // this would return false for disabled checkboxes
    }
}
