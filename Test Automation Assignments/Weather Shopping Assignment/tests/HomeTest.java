package tests;

import org.testng.annotations.Test;
import pages.Homepage;
import pages.MoisturizerPage;

import pages.SunscreenPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomeTest extends Basetest
{
    @Test
    public void testHomepageMoisturizerLink()
    {
        Homepage page = new Homepage(driver);
        String temp = page.GetTemperature();
        System.out.println(temp);

        MoisturizerPage page1 = page.clickBuyMoisturizers();
        assertEquals("https://weathershopper.pythonanywhere.com/moisturizer", page.ValidateURL());
    }

    @Test
    public void testHomepageSunscreenLink()
    {
        Homepage page = new Homepage(driver);
        SunscreenPage page2= page.clickBuySunscreen();
        assertEquals("https://weathershopper.pythonanywhere.com/sunscreen",page.ValidateURL());

    }
}
