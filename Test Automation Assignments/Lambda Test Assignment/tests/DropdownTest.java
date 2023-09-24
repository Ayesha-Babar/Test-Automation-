package tests;

import pages.DropdownDemoPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest
{
    @Test(dataProvider = "Drop Down",dataProviderClass = Dataproviders.class,priority = 1,groups={"smoke"},description="Verify the basic dropdown functionality")
    public void dropdownTest(String text)
    {
        DropdownDemoPage dropdown = homepage1.clickdropdowndemo();

        dropdown.SelectfromSelectOption(text);
        assertTrue(dropdown.GetSelectConfirmation());
    }
    @Test(dataProvider = "Drop Down2",dataProviderClass = Dataproviders.class,priority = 2,groups={"smoke"},description="Verify the basic dropdown functionality")
    public void dropdowntest2(String t1, String t2)
    {

        DropdownDemoPage dropdown = homepage1.clickdropdowndemo();
        dropdown.SelectfromMultiSelectOption(t1);
        dropdown.ClickFirstSelected();
        assertEquals(dropdown.DisplayFirstSelectedOption(),t1);

        dropdown.SelectfromMultiSelectOption(t2);
        dropdown.ClickGetLastSelected();
        assertEquals(dropdown.DisplayLastSelectedOption(),t2);


    }

}
