package tests;

import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.MoisturizerPage;


import static org.testng.AssertJUnit.assertEquals;

public class MoisturizerTest extends Basetest
{
    @Test
    public void testAloe()
    {
        MoisturizerPage page= homepage.clickBuyMoisturizers();
        int price= page.clickAloe();
        CheckoutPage check= page.clickCart();
        assertEquals(check.checkTotalPrice(),price);

    }

    @Test
    public void testAlmond()
    {
        MoisturizerPage page= homepage.clickBuyMoisturizers();
        int price=page.clickAlmond();
        CheckoutPage check= page.clickCart();
        assertEquals(check.checkTotalPrice(),price);
    }
}