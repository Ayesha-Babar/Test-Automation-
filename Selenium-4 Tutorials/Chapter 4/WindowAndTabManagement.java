package Tests;

import Tests.baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;


public class WindowAndTabManagement extends baseclass
{
    @Test
    public void testNewWindow()
    {
        WebDriver newWindow=driver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get("https://www.amazon.com");
        System.out.println("title: "+ driver.getTitle());
    }
    @Test
    public void testNewWindowTab()
    {
        WebDriver anotherWindow=driver.switchTo().newWindow(WindowType.TAB);
        anotherWindow.get("https://google.com");
        System.out.println("title: "+driver.getTitle());
    }
    @Test
    public void testWorkingBothWindows()
    {
        //automatically open and switch to new window or tab
        driver.switchTo().newWindow(WindowType.TAB).get("https://automated-360.com/test-page/");
        System.out.println("title: "+driver.getTitle());

        //automatically open and switch to a new tab or window
        driver.findElement(By.id("email")).sendKeys("tomsmith@gmail.com");
        driver.findElement(By.id("psw")).sendKeys("1234");
        driver.findElement(By.id("psw-repeat")).sendKeys("1234");
        driver.findElement(By.xpath("//label[@for='css']")).click();
        driver.findElement(By.id("age2")).click();
        driver.findElement(By.xpath("//button[@type='submit' and @class='registerbtn']")).click();

        // get the window ID handles
        Set<String> allWindowTabs=driver.getWindowHandles();
        Iterator<String> iterate=allWindowTabs.iterator();
        String mainFirstWindow=iterate.next();

        //switch and work in the main window or tab
        driver.switchTo().window(mainFirstWindow);
        // this must take the user to orangehrm,add his username and password and click login button
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

}
