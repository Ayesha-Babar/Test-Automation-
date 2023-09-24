package tests;


import pages.TablefilterPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TableFiltertest extends BaseTest
{
    @Test(priority = 1,groups={"smoke,sanity"},description = "Verify that table filters work as expected and Test filter interactions")
    public void test()
    {
        TablefilterPage page= homepage1.clickTableFilter();
        System.out.println(page.FilterTableEntries());
        System.out.println("The size of entries in the table is: "+page.GetTablesize());
        assertEquals(page.GetTablesize(),5);
    }

    @Test(priority = 2,groups={"smoke","sanity"},description = "Verify that table filters work as expected and Test filter interactions")
    public void testHyperExecute()
    {
        TablefilterPage page= homepage1.clickTableFilter();
        page.clickHyperExecute();
        System.out.println("The size of entries in the table is: "+page.GetTablesize());
        assertTrue(page.isHyperExecutorDisplayed());

    }

    @Test(priority = 3,groups={"smoke","sanity"},description = "Verify that table filters work as expected and Test filter interactions")
    public void testSeleniumTesting()
    {
        TablefilterPage page= homepage1.clickTableFilter();
        page.clickSeleniumTesting();
        assertTrue(page.isSeleniumEntryDisplayed());
    }

   @Test(priority = 4,groups={"smoke","sanity"},description = "Verify that table filters work as expected and Test filter interactions")
   public void testAll()
{
    TablefilterPage page= homepage1.clickTableFilter();
    page.clickAll();
    assertTrue(page.AreAllEntriesDisplayed());
}


}

