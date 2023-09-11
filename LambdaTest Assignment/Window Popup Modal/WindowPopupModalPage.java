package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import java.util.Set;

public class WindowPopupModalPage
{
    WebDriver driver;
    private By Twitter_Button=By.xpath("//a[@title='Follow @Lambdatesting on Twitter']");
    private By Facebook_button=By.xpath("//a[@title='Follow @Lambdatesting on Facebook']");
    private By linkedin_Button=By.xpath("//a[@title='Follow @Lambdatesting on Linkedin']");
    private By URLfield= By.xpath("//input[@type='url']");
    private By OpenURL_Button= By.xpath("//*[@id=\"__next\"]/section[2]/div/div/div[2]/div/a");

    //Multiple Windows popup modals
    private By openFacebookAndLinkedin= By.id("followboth");
    private By FollowAll_Button=By.id("followall");
    public WindowPopupModalPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public String FetchTheWindowHandle()
    {
        return driver.getWindowHandle();
    }

    public void clickFollowOnTwitter()
    {
        driver.findElement(Twitter_Button).click();
    }
    public int GetWindowHandlesSize()
    {
        Set<String> windowhandles= driver.getWindowHandles();
        return windowhandles.size();
    }

    public void clickLikeonFacebook()
    {
        driver.findElement(Facebook_button).click();
    }

    public String OpenURL()
    {
        driver.findElement(URLfield).sendKeys("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
        driver.findElement(OpenURL_Button).click();
        driver.getWindowHandle();
        return driver.getCurrentUrl();
    }

    public void clickLinkedin()
    {
        driver.findElement(linkedin_Button).click();
    }

    public int clickFollowTwitterandFacebook()
    {
        driver.findElement(openFacebookAndLinkedin).click();
        Set<String> windowhandles= driver.getWindowHandles();
        return windowhandles.size();
    }
}
