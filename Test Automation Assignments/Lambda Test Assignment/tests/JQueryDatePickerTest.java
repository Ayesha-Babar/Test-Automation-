package tests;

import pages.JQueryDatePickerPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class JQueryDatePickerTest extends BaseTest
{
    @Test(dataProvider ="JQuery Date picker",dataProviderClass = Dataproviders.class,priority = 1,groups={"smoke"},description = " Verify that the jQuery date picker component works as expected")
    public void Test_fromField(String date)
    {
        JQueryDatePickerPage page = homepage1.clickJQueryDatePicker();
        page.clickFrom();
        page.Select_FromDate(date);
        assertTrue(page.GetText_From().contains(date));
    }

    @Test(dataProvider="JQuery Date pciker", dataProviderClass = Dataproviders.class,priority = 2,groups={"smoke"},description = " Verify that the jQuery date picker component works as expected")
    public void Test_ToField(String date)
    {
        JQueryDatePickerPage page = homepage1.clickJQueryDatePicker();
        page.clickTo();
        page.Select_ToDate(date);
        assertEquals(date,page.GetText_From());
    }

}
