package Tests;

import Tests.baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class getRectClass extends baseclass
{
    /*@BeforeClass

    public void Initialize()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationu.applitools.com/learningpaths.html?id=java-web-ui-path");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }*/
    @Test
    public void getPositionDimension()
    {
        driver.get("https://testautomationu.applitools.com/learningpaths.html?id=java-web-ui-path");
        WebElement logoTAU= driver.findElement(
                By.xpath("//div[@id='app']//header/a/img"));
        Rectangle rectTAUlogo=logoTAU.getRect();
        System.out.println("x: "+rectTAUlogo.getX());
        System.out.println("y: "+rectTAUlogo.getY());
        System.out.println("width: "+rectTAUlogo.getWidth());
        System.out.println("Height: "+rectTAUlogo.getHeight());

    }

}
