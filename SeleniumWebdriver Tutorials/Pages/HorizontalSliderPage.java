package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage
{

        private WebDriver driver;
        private By slider= By.xpath("//div[@class='sliderContainer']//input[@type='range']");
        private By sliderPosition= By.id("range");

        public HorizontalSliderPage(WebDriver driver)
        {
            this.driver=driver;
        }

        public void moveSliderToPosition(int desiredPosition)
        {
            desiredPosition=4;
            driver.findElement(slider).click();
            for(int i=0;i<3;i++)
            {
                driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
            }
        }

        public int getSliderPosition()
        {
            String span = driver.findElement(sliderPosition).getText();
            int position= Integer.parseInt(span);
            return position;
        }



}
