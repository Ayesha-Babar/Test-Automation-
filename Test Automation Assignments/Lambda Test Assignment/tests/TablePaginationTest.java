package tests;

import pages.TablePaginationPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TablePaginationTest extends BaseTest
{
    @Test(priority = 1,groups = {"smoke","sanity"},description="Verify that table pagination allows navigation through data and Test pagination interactions")
    public void test()
    {
        TablePaginationPage page= homepage1.clicktablePagination();
        String rows="5";
        page.Selectrows(rows);
        assertEquals(5,page.GetNoOfRows());

    }

}
