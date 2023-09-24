package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDOM
{
    WebDriver driver;
    private By shadowhost= By.id("shadow_host");



    public ShadowDOM(WebDriver driver)
    {
        this.driver= driver;
    }

    public void shadowText()
    {
        WebElement shadow_host= driver.findElement(shadowhost);
       // WebElement shadow_root= (WebElement) shadow_host.getShadowRoot();


        // Execute JavaScript to create a Shadow DOM root
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //jsExecutor.executeScript("arguments[0].attachShadow({mode: 'open'});", shadow_host);

        // Find elements inside the Shadow DOM using JavaScript
        WebElement shadowRoot = (WebElement) jsExecutor.executeScript("return arguments[0].shadowRoot;", shadow_host);
        WebElement shadowElement = shadowRoot.findElement(By.xpath("//div//input"));

        // Perform actions on the Shadow DOM element
        shadowElement.sendKeys("ayesha");



    }



}
