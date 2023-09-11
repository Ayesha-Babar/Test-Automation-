package Base;

import Pages.BootstrapAlertMessagePage;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class BootstrapAlertTest extends BaseTest
{
    @Test
    public void AutoclosableSuccessTest()
    {
        BootstrapAlertMessagePage bootstrap= homepage1.clickBootstrapAlert();
        bootstrap.clickAutoclosableSuccessMassage_button();
        assertTrue(bootstrap.AutoclosableSuccessAlertDisplay());
    }

    @Test
    public void NormalSuccessTest()
    {
        BootstrapAlertMessagePage bootstrap= homepage1.clickBootstrapAlert();
        bootstrap.clickNormalSuccess();
        assertTrue(bootstrap.NormalSuccessAlertDisplay());
        bootstrap.clickclose();
    }

    @Test
    public void AutoclosableInfo()
    {
        BootstrapAlertMessagePage bootstrap= homepage1.clickBootstrapAlert();
        bootstrap.ClickAutoclosableInfo();
        bootstrap.AutoclosableInfoAlertDisplay();

    }

    @Test
    public void NormalInfoTest()
    {
        BootstrapAlertMessagePage bootstrap= homepage1.clickBootstrapAlert();
        bootstrap.clickNormalInfo();
        bootstrap.NormalInfoAlertDisplay();
    }


}
