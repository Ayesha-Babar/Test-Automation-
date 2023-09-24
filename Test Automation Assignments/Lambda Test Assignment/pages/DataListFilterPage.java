package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataListFilterPage
{
    private WebDriver driver;
    private By SearchField= By.id("input-search");
    private By result= By.xpath("//div[contains(@class,'info-block')]//h5");

    public DataListFilterPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void entertext(String text)
    {
        driver.findElement(SearchField).sendKeys(text);
    }

    public boolean searchResults(String text)
    {
        String t=driver.findElement(result).getText();
        if(t.contains(text))
        {
            return true;
        }
        return false;
    }
}
