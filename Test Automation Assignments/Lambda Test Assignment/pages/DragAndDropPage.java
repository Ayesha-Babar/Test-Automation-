package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage
{
    WebDriver driver;
    private By ItemToBeDragged= By.xpath("//span[text()='Draggable 1']");
    private By DropHereMenu= By.id("mydropzone");
    private By droppedItemsList= By.id("droppedlist");

    private By DragMeToMyTarget= By.xpath("//div//p[text()='Drag me to my target']");
    private By Drophere= By.id("droppable");

    public DragAndDropPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void DragAndDrop()
    {
        WebElement itemTobeDragged= driver.findElement(ItemToBeDragged);
        WebElement drophereMenu= driver.findElement(DropHereMenu);
        Actions actions= new Actions(driver);
        actions.dragAndDrop(itemTobeDragged,drophereMenu).perform();
        actions.clickAndHold(itemTobeDragged).moveToElement(drophereMenu).release().build().perform();
    }

    public void DragAndDrop2()
    {
        WebElement itemtobedragged= driver.findElement(DragMeToMyTarget);
        WebElement drophere= driver.findElement(Drophere);
        Actions action= new Actions(driver);
        action.dragAndDrop(itemtobedragged,drophere).perform();
    }
    public String getText()
    {
        WebElement drophere= driver.findElement(Drophere);
        return drophere.getText();
    }

}
