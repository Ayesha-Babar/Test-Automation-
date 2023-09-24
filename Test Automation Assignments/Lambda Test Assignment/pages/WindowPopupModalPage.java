package pages;

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
    private By OpenURL_Button= By.linkText("Open URL");

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

    public String OpenURL(String url)
    {
        driver.findElement(URLfield).sendKeys(url);
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

    public int ClickFollowAll()
    {
        driver.findElement(FollowAll_Button).click();
        Set<String> windowhandles= driver.getWindowHandles();
        return windowhandles.size();
    }


}
