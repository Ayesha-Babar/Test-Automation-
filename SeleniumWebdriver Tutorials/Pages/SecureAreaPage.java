package Pages;

import Pages.loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage
{
    WebDriver driver;
    public SecureAreaPage(WebDriver driver)
    {
        this.driver=driver;
    }
    private By statusAlert= By.id("flash");
    private By Logout_Button= By.linkText("Logout");

    public String GetStatusAlert()
    {
       return driver.findElement(statusAlert).getText();
    }

    public loginPage clickLogoutButton()
    {
        driver.findElement(Logout_Button).click();
        return new loginPage(driver);
    }

}
