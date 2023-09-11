package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage
{
    WebDriver driver;
    private By menu= By.id("hot-spot");

    public ContextMenuPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void contextClick()
    {
        WebElement Menu= driver.findElement(menu);
        Actions actions = new Actions(driver);
        actions.contextClick(Menu).build().perform();
    }

    public String GetAlertText()
    {
        return driver.switchTo().alert().getText();
    }

    public void clickOk()
    {
        driver.switchTo().alert().accept();
    }
}
