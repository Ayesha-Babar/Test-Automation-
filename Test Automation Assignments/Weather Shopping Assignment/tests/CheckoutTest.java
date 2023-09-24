package tests;

import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.MoisturizerPage;

public class CheckoutTest extends Basetest
{

    @Test
    public void test()
    {
        MoisturizerPage p=homepage.clickBuyMoisturizers();
        CheckoutPage page = p.clickCart();
        page.checkTotalPrice();
        page.clickPaywithcard();
    }

}