package tests;

import pages.JQueryDatePickerPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class JQueryDatePickerTest extends BaseTest
{
    @Test(priority = 1,groups={"smoke"},description = " Verify that the jQuery date picker component works as expected")
    public void Test_fromField()
    {
        JQueryDatePickerPage page = homepage1.clickJQueryDatePicker();
        page.clickFrom();
        page.Select_FromDate();
      assertTrue(page.GetText_From().contains("10/15/2023"));
    }

    @Test(priority = 2,groups={"smoke"},description = " Verify that the jQuery date picker component works as expected")
    public void Test_ToField()
    {
        JQueryDatePickerPage page = homepage1.clickJQueryDatePicker();
        page.clickTo();
        page.Select_ToDate();
        assertEquals("09/26/2023",page.GetText_From());
    }

}
