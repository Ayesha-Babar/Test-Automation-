package Tests;

import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DropdownTest extends BaseTest
{
    @Test
    public void testSelectoption()
    {
        var dropdown=homepage.clickDropdown();
        System.out.println("clicking dropdown");
        String option="Option1";
        dropdown.selectfromdropdown(option);
        System.out.println("choosing option1");
        var selectedoptions=dropdown.getSelectedOptions();
        //assert that the list contains one item ie one item is selected
        // assert that the option passed in the argument is selected
        assertEquals("Incorrect number of selections",1,selectedoptions.size());
        assertTrue("Option not selected",selectedoptions.contains(option));
    }
}
