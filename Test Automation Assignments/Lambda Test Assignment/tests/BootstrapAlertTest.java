package tests;

import pages.BootstrapAlertMessagePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class BootstrapAlertTest extends BaseTest
{
    @Test(priority = 1,groups={"smoke,sanity"},description = "Verify basic Alert functionality and test alert appearance and dismissal")
    public void AutoclosableSuccessTest()
    {
        BootstrapAlertMessagePage bootstrap= homepage1.clickBootstrapAlert();
        bootstrap.clickAutoclosableSuccessMassage_button();
        assertTrue(bootstrap.AutoclosableSuccessAlertDisplay());
    }


    @Test(priority = 2,groups={"smoke,sanity"},description = "Verify basic Alert functionality and test alert appearance and dismissal")
    public void NormalSuccessTest()
    {
        BootstrapAlertMessagePage bootstrap= homepage1.clickBootstrapAlert();
        bootstrap.clickNormalSuccess();
        assertTrue(bootstrap.NormalSuccessAlertDisplay());
        bootstrap.clickclose();
    }

    @Test(priority = 3,groups={"smoke,sanity"},description = "Verify basic Alert functionality and test alert appearance and dismissal")
    public void AutoclosableInfo()
    {
        BootstrapAlertMessagePage bootstrap= homepage1.clickBootstrapAlert();
        bootstrap.ClickAutoclosableInfo();
        bootstrap.AutoclosableInfoAlertDisplay();

    }

    @Test(priority = 4,groups={"smoke,sanity"},description = "Verify basic Alert functionality and test alert appearance and dismissal")
    public void NormalInfoTest()
    {
        BootstrapAlertMessagePage bootstrap= homepage1.clickBootstrapAlert();
        bootstrap.clickNormalInfo();
        bootstrap.NormalInfoAlertDisplay();
    }


}
