package Base;

import Pages.JQueryDatePickerPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class JQueryDatePickerTest extends BaseTest
{
    @Test
            public void Test_fromField()
    {
        JQueryDatePickerPage page = homepage1.clickJQueryDatePicker();
        page.clickFrom();
        page.Select_FromDate();
        assertTrue(page.GetText_From().contains(" 09/15/2023"));
    }

    @Test
    public void Test_ToField()
    {
        JQueryDatePickerPage page = homepage1.clickJQueryDatePicker();
        page.clickTo();
        page.Select_ToDate();
        assertTrue(page.GetText_From().contains(" 26/15/2023"));
    }

}
