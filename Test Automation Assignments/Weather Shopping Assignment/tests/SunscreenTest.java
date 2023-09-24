package tests;

import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.SunscreenPage;

import static org.testng.AssertJUnit.assertEquals;

public class SunscreenTest extends Basetest
{
    @Test
    public void testSPF50()
    {
        SunscreenPage page = homepage.clickBuySunscreen();
        int price=page.AddSPF50();
        CheckoutPage check =page.clickCart();
        assertEquals(check.checkTotalPrice(),price);
    }

    @Test
    public void testSPF30()
    {
        SunscreenPage page = homepage.clickBuySunscreen();
        int price=page.AddSPF30();
        CheckoutPage check=  page.clickCart();
        assertEquals(check.checkTotalPrice(),price);

    }
}