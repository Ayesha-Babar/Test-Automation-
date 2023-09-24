package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableSortAndSearch
{
    private WebDriver driver;
    private By Search= By.xpath("//input[@type='search']");
    private By Name=By.xpath("//th[text()='Name']");
    private By NextButton= By.xpath("//a[@aria-controls='example' and text()='Next']");
    private By NameColoumn= By.xpath("//tbody//tr//td[1]");
    public TableSortAndSearch(WebDriver driver)
    {
        this.driver=driver;

    }

    public void ClickName()
    {
        driver.findElement(Name).click();
    }

    public String SortConfirmation()
    {
        List<WebElement>names= driver.findElements(NameColoumn);
        return names.get(0).getText();

    }

    public boolean SearchConfirmation(String name)
    {
        driver.findElement(Search).sendKeys(name);
        List<WebElement>names= driver.findElements(NameColoumn);
        if(names.get(0).getText().contains(name))
        {
            return true;
        }
        return false;
    }


}

