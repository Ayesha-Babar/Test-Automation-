package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage
{
    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By UsernameField= By.id("username");
    private By PasswordField=By.id("password");
    private By Login_Button=By.cssSelector("#login button");

    public void SetUsername(String username)
    {
        driver.findElement(UsernameField).sendKeys(username);
    }

    public void SetPassword(String password)
    {
        driver.findElement(PasswordField).sendKeys(password);
    }

    public SecureAreaPage clickloginButton()
    {
        driver.findElement(Login_Button).click();
        return new SecureAreaPage(driver);
    }
}
