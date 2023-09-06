package Tests;

import Pages.SecureAreaPage;
import Pages.loginPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class logintests extends BaseTest
{
    @Test
    public void testSuccessfulLogin()
        {
           loginPage loginpage= homepage.clickformAuthenticationLink();
           loginpage.SetUsername("tomsmith");
           loginpage.SetPassword("SuperSecretPassword!");
           SecureAreaPage securearepage =loginpage.clickloginButton();
           assertTrue("Alert message wrong", securearepage.GetStatusAlert().contains("You logged into a secure area!"));

        }
}
