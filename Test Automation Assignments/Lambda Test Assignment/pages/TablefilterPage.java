package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class TablefilterPage {
    private WebDriver driver;
    private By TableEntries = By.xpath("//div[@class='table-container']//table//tbody//tr");
    private By Buttons = By.xpath("//button[@type='button']");
    private By HyperExecuteButton=By.xpath("//button[@type='button' and text()='HyperExecute']");
    private By HyperExecuteEntry1= By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td");
    private By HyperExecuteEntry2= By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[4]");
    private By SeleniumTestingButton=By.xpath("//button[@type='button' and text()='Selenium Testing']");
    private By SeleniumEntry= By.xpath("//tr[@data-status= 'pendiente']");
    private By CypressTestingButton= By.xpath("//button[@type='button' and text()='Cypress Testing']");
    private By AllButton= By.xpath("//button[@type='button' and text()='All']");

        public TablefilterPage(WebDriver driver) {
        this.driver = driver;
    }


    public int GetTablesize() {
        int rowCount = driver.findElements(TableEntries).size();
        return rowCount;
    }

    public String FilterTableEntries() {
        List<WebElement> list = driver.findElements(TableEntries);
        return list.stream().map(s -> s.getText()).collect(Collectors.toList()).toString();

    }

    public void clickHyperExecute()
    {
        driver.findElement(HyperExecuteButton).click();
    }

    public boolean isHyperExecutorDisplayed()
    {
        WebElement entry1= driver.findElement(HyperExecuteEntry1);
        WebElement entry2= driver.findElement(HyperExecuteEntry2);
        return (entry1.isDisplayed() && entry2.isDisplayed());
    }

    public void clickSeleniumTesting()
    {
        driver.findElement(SeleniumTestingButton).click();
    }

    public boolean isSeleniumEntryDisplayed()
    {
        List<WebElement> SeleniumEntries= driver.findElements(SeleniumEntry);
       for(WebElement entry: SeleniumEntries)
       {
           if(entry.isDisplayed())
               return true;

       }
        return false;

    }

    public void clickAll()
    {
        driver.findElement(AllButton).click();
    }

    public boolean AreAllEntriesDisplayed()
    {
       List<WebElement>Allentries= driver.findElements(TableEntries);
       for(WebElement entry:Allentries)
       {
           if(entry.isDisplayed())
           {
               return true;
           }
       }
       return false;
    }
}


