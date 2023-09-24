package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BootstrapListPage {
    WebDriver driver;
    private By Entry = By.xpath("//li[text()='MuOUHMcWZmGVqbIJ']");
    private By MoveRightButton = By.xpath("//button[contains(@class, 'move-right')]");
    private By RightList = By.xpath("//div[contains(@class,'dual-list list-right')]//div//ul[contains(@class, 'sp_list_group')]");


    public BootstrapListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void SelectTheElement() {
        driver.findElement(Entry).click();
    }

    public void ClickRight() {
        driver.findElement(MoveRightButton).click();
    }


    public List<WebElement> getRightListElements() {
        WebElement rightListContainer = driver.findElement(RightList);
        List<WebElement> rightListElements = rightListContainer.findElements(By.tagName("li"));
        return rightListElements;
    }

    public Dimension GetSizeOfList()
    {
        WebElement rightListContainer = driver.findElement(RightList);
        return rightListContainer.getSize();
    }



}
