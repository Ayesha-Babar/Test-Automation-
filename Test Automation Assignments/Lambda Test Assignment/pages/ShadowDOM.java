package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDOM
{
    WebDriver driver;
    private By shadowhost= By.id("shadow_host");
    private final int wait_For_element= 30;
    private By username= By.name("username");
    private By email= By.name("email");
    private By password= By.name("password");
    private By confirmPassword=By.name("confirm_password");
    private By submit_button= By.xpath("//button[text()='Submit']");


    public ShadowDOM(WebDriver driver)
    {
        this.driver= driver;

    }

    public void fillform(String name, String Password,String confirmpassword,String Email)
    {
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(confirmPassword).sendKeys(confirmpassword);
        driver.findElement(email).sendKeys(Email);
        driver.findElement(submit_button).click();
    }

    public void shadowdomtext()
    {
       var shadow_host=driver.findElement(shadowhost);
       var shadow_root=shadow_host.getShadowRoot();
      var shadowcontent= shadow_root.findElement(By.cssSelector("#shadow_content"));
      shadowcontent.findElement(By.cssSelector("div input[type='text']")).sendKeys("ayesha");

    }

    public void shadoww()
    {
        var shadowhost= driver.findElement(By.tagName("unique-signup-form"));
        var shadowroot= shadowhost.getShadowRoot();
        var username= shadowroot.findElement(By.cssSelector("input[name='username']"));
        username.sendKeys("aha");
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
        WebElement shadowElement = shadowRoot.findElement(By.cssSelector("input[name='username']"));

        // Perform actions on the Shadow DOM element
        shadowElement.sendKeys("ayesha");



    }



}
