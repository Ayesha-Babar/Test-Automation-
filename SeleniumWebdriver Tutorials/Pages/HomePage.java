package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage
{
    private WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }


    public void clickLink(String linktext)
    {
        driver.findElement(By.linkText(linktext)).click();

    }
    public loginPage clickformAuthenticationLink()
    {
      clickLink("Form Authentication");
        return new loginPage(driver);
    }

    public DropdownPage clickDropdown()
    {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoverPage clickHover()
    {
        clickLink("Hovers");
        return new HoverPage(driver);
    }

    public KeyPressPage clickKeypress()
    {
        clickLink("Key Presses");
        return new KeyPressPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider()
    {
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public JavascriptAlertsPage clickjavascriptAlerts()
    {
        clickLink("JavaScript Alerts");
        return new JavascriptAlertsPage(driver);
    }

}
