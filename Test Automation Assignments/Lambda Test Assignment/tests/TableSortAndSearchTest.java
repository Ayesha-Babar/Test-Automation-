package tests;

import pages.TableSortAndSearch;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TableSortAndSearchTest extends BaseTest
{
    @Test(dataProvider = "Table sort and search",dataProviderClass = Dataproviders.class,priority = 1,groups={"smoke"},description="Verify that table sorting and searching functions are functional")
    public void testSort(String name)
    {
        TableSortAndSearch page= homepage1.clickTableSearch();
        page.ClickName();
        page.ClickName();
       assertEquals(page.SortConfirmation(),name);
    }

    @Test(dataProvider = "Table sort and search",dataProviderClass = Dataproviders.class,priority = 2,groups={"smoke"},description="Verify that table sorting and searching functions are functional")
    public void testSearch(String name)
    {
        TableSortAndSearch page= homepage1.clickTableSearch();
        assertTrue(page.SearchConfirmation(name));

    }

}
