package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableDataSearchPage
{
    private WebDriver driver;

    private By FilterField= By.id("task-table-filter");
    private By FilterButton=By.xpath("//button[text()='Filter']");
    private By developmentText= By.xpath("//*[@id=\"task-table\"]/tbody/tr[1]/td[2]");
    private By IdField= By.xpath("//input[@type='text' and @placeholder='#']");
    private By UsernameField= By.xpath("//input[@type='text' and @placeholder='Username']");
    private By idnumber= By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[1]");
    public TableDataSearchPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public void EnterField(String text)
    {
        driver.findElement(FilterField).sendKeys(text);
    }

    public boolean isFieldDisplayed()
    {
        WebElement development= driver.findElement(developmentText);
        return development.isDisplayed();
    }

    public void clickFilter()
    {
        driver.findElement(FilterButton).click();
    }

    public void Enterid(String id)
    {
        driver.findElement(IdField).sendKeys(id);

    }

    public boolean isIdDisplayed()
    {
        return driver.findElement(idnumber).isDisplayed();
    }
}
