package Base;

import Pages.DropdownDemoPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest
{
    @Test
    public void dropdownTest()
    {
        DropdownDemoPage dropdown= homepage1.clickdropdowndemo();

        dropdown.SelectfromSelectOption("Sunday");
        assertEquals("The day selected message is incorrect",dropdown.DisplayDaySelectedMessage(),"Day selected :- Sunday");

        dropdown.SelectfromMultiSelectOption("California");
        dropdown.SelectfromMultiSelectOption("Ohio");

        dropdown.ClickFirstSelected();
        assertEquals("The first selected option is incorrect",dropdown.DisplayFirstSelectedOption(),"California");
        dropdown.ClickGetLastSelected();
        assertEquals("The last selected option is incorrect",dropdown.DisplayLastSelectedOption(),"Ohio");


    }

}
