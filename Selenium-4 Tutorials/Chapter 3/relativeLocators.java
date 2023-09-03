package Tests;

import Tests.baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class relativeLocators extends baseclass {



    @Test
    public void testRelativeLocator() {

        //input[@placeholder='Username']
        List<WebElement> credentials = driver.findElements(By.xpath("//p[@class='']"));
        System.out.println("123");
        for (WebElement a : credentials) {
            System.out.println(a.getText());

        }
    }


    //WebElement name = driver.findElement(By.tagName("p"));
    //System.out.println(name);*/
    // WebElement name= driver.findElement(By.xpath( "//p[@class='oxd-text oxd-text--p' and text]"));
    //System.out.println(name.getText());


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

