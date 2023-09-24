package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxDemoPage {
    static WebDriver driver;

    public CheckboxDemoPage(WebDriver driver) {
        this.driver = driver;
    }
    private By SingleCheckbox = By.id("isAgeSelected");
    private By CheckedMessage = By.id("txtAge");
    private By disabled_checkboxes = By.xpath("//input[@type='checkbox' and @disabled]");
    private By MultipleCheckboxes = By.xpath("//input[@type='checkbox' and @class='cb-element mr-10']");
    private By CheckAll_Button = By.xpath("//input[@value='Check All']");

    public void clickFirstCheckBox() {
        driver.findElement(SingleCheckbox).click();
    }

    public String DisplayCheckedMessage() {
        return driver.findElement(CheckedMessage).getText();
    }

    public boolean checkDisabled() {

        List<WebElement>DisabledcheckBoxes=driver.findElements(disabled_checkboxes);
        for (WebElement checkbox: DisabledcheckBoxes)
        {
            if(checkbox.isEnabled())
            {
                return true;
            }
        }
        return false;
        // this should return false
    }

    public void clickCheckAllButton() {
        driver.findElement(CheckAll_Button).click();
    }

    public boolean checkClickAll() {
        // this function would check if after clicking check all, all checkboxes are checked or not
        List<WebElement> MultipleCheckBoxes = driver.findElements(MultipleCheckboxes);
        for (WebElement checkbox : MultipleCheckBoxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;


    }
}