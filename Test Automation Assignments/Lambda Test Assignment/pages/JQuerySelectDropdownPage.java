package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class JQuerySelectDropdownPage {
    WebDriver driver;
    private By country_dropdown = By.id("country");
    private By state_dropdown = By.xpath("//select[contains(@class,'js-example-basic')]");
    private By disabled_dropdown = By.xpath("//select[contains(@class,'js-example-disabled')]");
    private By disabledOptions = By.xpath("//li[@aria-disabled='true']");

    public JQuerySelectDropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void SelectDropdown(String country) {
        WebElement dropdown1 = driver.findElement(country_dropdown);
        Select drop = new Select(dropdown1);
        drop.selectByVisibleText(country);
    }

    public String checkDropdown() {
        WebElement dropdown1 = driver.findElement(country_dropdown);
        Select drop = new Select(dropdown1);
        WebElement selected = drop.getFirstSelectedOption();
        return selected.getText();

    }

    public void SelectState(String state1, String state2) {
        WebElement dropdown = driver.findElement(state_dropdown);
        Select dd = new Select(dropdown);
        dd.selectByVisibleText(state1);
        dd.selectByVisibleText(state2);
    }

    public int checkStatesize() {
        WebElement dropdown = driver.findElement(state_dropdown);
        Select dd = new Select(dropdown);
        List<WebElement> state = dd.getAllSelectedOptions();
        return state.size();

    }

    public void SelectDisabled(String country) {
        WebElement disabled = driver.findElement(disabled_dropdown);
        Select select = new Select(disabled);
        select.selectByVisibleText(country);

    }

    public boolean Checkdisabled() {
        List<WebElement> disabled = driver.findElements(disabledOptions);
        for (WebElement option : disabled) {
            if (option.isEnabled())
                return false;
        }
        return true;


    }
}

