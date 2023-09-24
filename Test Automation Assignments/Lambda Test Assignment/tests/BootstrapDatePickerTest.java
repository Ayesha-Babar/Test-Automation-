package tests;

import org.testng.annotations.DataProvider;
import pages.BootstrapDatePickerPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class BootstrapDatePickerTest extends BaseTest
{
    @Test(dataProvider = "Bootstrap date picker2",dataProviderClass = Dataproviders.class,priority = 1,groups={"smoke","sanity"},description = "Verify basic bootstrap date picker functionality and test date selection")
    public void test(String date)
    {
        BootstrapDatePickerPage page= homepage1.clickBootstrapDatePicker();
        page.EnterText(date);
        assertEquals("03/04/2007",page.TextConfirmation());
    }

    @Test(dataProvider="Bootstrap date picker",dataProviderClass = Dataproviders.class,priority = 2,groups={"smoke","sanity"},description = "Verify basic bootstrap date picker functionality and test date selection")
    public void testDate(String startdate, String enddate)
    {
        BootstrapDatePickerPage page= homepage1.clickBootstrapDatePicker();
        page.EnterDate(startdate,enddate);
        assertEquals("15/02/2022",page.StartDateConfirmation());
        assertEquals("20/02/2022",page.EndDateConfirmation());
    }

}
