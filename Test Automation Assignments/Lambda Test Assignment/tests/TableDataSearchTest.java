package tests;

import pages.TableDataSearchPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TableDataSearchTest extends BaseTest
{
    @Test(dataProvider = "Table data search",dataProviderClass = Dataproviders.class,priority = 1,groups={"smoke","regression"},description = "Verify that table data can be searched effectively and  Test data search behavior with various table structures")
    public void test(String text)
    {
        TableDataSearchPage page= homepage1.clickTableDataSearch();
        page.EnterField(text);
        assertTrue(page.isFieldDisplayed());
    }

    @Test(dataProvider = "Table data search2",dataProviderClass = Dataproviders.class,priority = 2,groups={"smoke","regression"},description = "Verify that table data can be searched effectively and  Test data search behavior with various table structures")
    public void test1(String id)
    {
        TableDataSearchPage page= homepage1.clickTableDataSearch();
        page.clickFilter();
        page.Enterid(id);
        assertTrue(page.isIdDisplayed());
    }


}
