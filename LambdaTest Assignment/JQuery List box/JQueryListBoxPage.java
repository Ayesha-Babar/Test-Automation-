package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JQueryListBoxPage
{
    WebDriver driver;
    private By PickDataList=By.xpath("//select[contains(@class,'pickData')]");
    private By Add_Button= By.xpath("//button[text()='Add']");
    private By AddAll_Button= By.xpath("//button[text()='Add All']");
    private By Remove_Button=By.xpath("//button[text()='Remove']");
    private By RemovaAll_Button=By.xpath("//button[text()='Remove All']");
    private By ReturnDataList= By.xpath("//select[contains(@class,'pickListResult')]");
    public JQueryListBoxPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void AddOneElement()
    {
        driver.findElement(PickDataList).sendKeys("Andrea");
        driver.findElement(Add_Button).click();
    }

    public int getReturnDataListCount() {
        List<WebElement> elements = driver.findElements(ReturnDataList);
        return elements.size();
    }

    public int getPickDataListCount() {
        List<WebElement> elements = driver.findElements(PickDataList);
        return elements.size();
    }



    public void AddAll()
    {
        driver.findElement(AddAll_Button).click();
    }

    public void RemoveOneElement()
    {
        driver.findElement(ReturnDataList).sendKeys("Liam");
        driver.findElement(Remove_Button).click();
    }

    public void RemoveAll()
    {
        driver.findElement(RemovaAll_Button).click();
    }

}
