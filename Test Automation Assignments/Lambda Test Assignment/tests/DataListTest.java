package tests;

import org.testng.annotations.Test;
import pages.DataListFilterPage;

import static org.testng.AssertJUnit.assertTrue;

public class DataListTest extends BaseTest
{
    @Test(dataProvider = "Data List Filter",dataProviderClass = Dataproviders.class)
    public void test(String text)
    {
        DataListFilterPage page = homepage1.clickdataList();
        page.entertext(text);
        assertTrue(page.searchResults(text));
    }
}
