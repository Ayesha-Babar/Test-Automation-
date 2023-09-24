package tests;

import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.MoisturizerPage;
import pages.PaymentSuccessPage;

import static org.testng.AssertJUnit.assertEquals;

public class PaymentSuccessTest extends Basetest
{

    @Test
    public void test()
    {
        CheckoutPage checkout = new CheckoutPage(driver);
        MoisturizerPage mois= homepage.clickBuyMoisturizers();
        mois.clickAlmond();
        mois.clickCart();

        PaymentSuccessPage page= checkout.clickPaywithcard();
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        driver.switchTo().defaultContent();

        System.out.println(page.IsconfirmationTextDisplayed());
        assertEquals("Your payment was successful. You should receive a follow-up call from our sales team.",page.IsconfirmationTextDisplayed());

    }


}