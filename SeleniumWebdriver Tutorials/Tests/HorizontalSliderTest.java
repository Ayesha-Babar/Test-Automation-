package Tests;

import Pages.HorizontalSliderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HorizontalSliderTest extends BaseTest
{
    @Test
    public void SliderTest()
    {
        HorizontalSliderPage slider= homepage.clickHorizontalSlider();
        slider.moveSliderToPosition(4);
        assertEquals(slider.getSliderPosition(),4);
    }



}