package tests;

import pages.JQuerySelectDropdownPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class JQueryDropdownTest extends BaseTest
{
    @Test(dataProvider = "JQuery dropdown",dataProviderClass = Dataproviders.class,priority = 1,groups={"smoke"},description="Verify the basic dropdown functionality")
    public void testFirstDropdown(String country)
    {
        JQuerySelectDropdownPage page = homepage1.clickJQueryDropdown();
       page.SelectDropdown(country);
       assertEquals(page.checkDropdown(),country);
    }

    @Test(dataProvider = "JQuery dropdown2",dataProviderClass = Dataproviders.class,priority = 2,groups={"smoke"},description="Verify the basic dropdown functionality")
    public void testSecondDropdown(String state1, String state2)
    {
        JQuerySelectDropdownPage page = homepage1.clickJQueryDropdown();
        page.SelectState(state1, state2);
        assertEquals(2,page.checkStatesize());
    }

    @Test(dataProvider = "JQuery dropdown3",dataProviderClass = Dataproviders.class,priority = 3,groups={"smoke"},description="Verify the basic dropdown functionality")
    public void testThirdDropdown(String country)
    {
        JQuerySelectDropdownPage page = homepage1.clickJQueryDropdown();
        page.SelectDisabled(country);
        page.Checkdisabled();

    }





}
