package Tests;

import Tests.baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshots extends baseclass
{

   @Test
    public void takeWebElementScreenshot()
   {
       driver.get("https://testautomationu.applitools.com/learningpaths.html?id=java-web-ui-path");
       WebElement TAULogo= driver.findElement(By.xpath("//div[@id='app']//div//header/a/img[@class='logo']")) ;
      File source= TAULogo.getScreenshotAs(OutputType.FILE);
      File destination= new File("Next generation platform.png");
      try {
          FileHandler.copy(source, destination);
      }catch(IOException e)
      {
          throw new RuntimeException(e);
      }

   }
   @Test
    public void takePageSectionScreenshot()
   {
       driver.get("https://testautomationu.applitools.com/");
       WebElement TAUPageSection= driver.findElement(By.className("//div//section[@class='jumbotron heroSection mainBg']"));
       File source=TAUPageSection.getScreenshotAs(OutputType.FILE);
       File destination=new File("TAUPageSection");
       try{
           FileHandler.copy(source,destination);
       }catch(IOException e)
       {
           throw new RuntimeException(e);
       }
   }

}
