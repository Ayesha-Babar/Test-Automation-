package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TablePaginationPage {
    WebDriver driver;
    private By SelectRows= By.xpath("//select[@name='state']");
    private By VisibleRowsOnPage= By.cssSelector("tr:not([style*=\"display: none;\"])");

   public TablePaginationPage(WebDriver driver)
   {
       this.driver=driver;
   }


    public void Selectrows(String NoOfRows)
    {
       WebElement rowDropdown= driver.findElement(SelectRows);
       Select select= new Select(rowDropdown);
       select.selectByVisibleText(NoOfRows);
    }

    public int GetNoOfRows()
    {
       List<WebElement> rows= driver.findElements(VisibleRowsOnPage);
       return rows.size()-1;
    }
}






    /*
    // All 40 first names can be accessed through this:
    private By rows= By.xpath("//table//tbody//tr");
    // to access a particular row add index in tr
    // to access a particular coloumn add index in td

    private By FirstName= By.xpath("//table//tbody//tr//td[2]");
    private By NextButton= By.xpath("//*[@id=\"prev\"]/span/span");
    List<WebElement> FirstNames= driver.findElements(FirstName);
    List<String>names=new ArrayList<String>();
    List<WebElement> FirstNamesList = driver.findElements(FirstName);
    public TablePaginationPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void extractNames() {

        for (WebElement n : FirstNamesList) {
            // Extract the text from the WebElement
            String firstName = n.getText();
            names.add(firstName);
        }
    }
    
    public void nextButton() {
        WebElement nextButton = driver.findElement(NextButton);
        while (nextButton.isEnabled())
        {
             extractNames();
             nextButton.click();

        }
    }

    public void PrintNames()
    {
        for (WebElement name: FirstNames)
        {
            System.out.println(name);
        }
    }*/




