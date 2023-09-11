package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TablePaginationPage
{
    WebDriver driver;
    // All 40 first names can be accessed through this:
    private By FirstName= By.xpath("//table[@id='table-id']/tbody/tr[position() > 0]/td[position() = 2]");
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
    }



    }
