package Base;

import Pages.TablePaginationPage;
import org.testng.annotations.Test;

public class TablePaginationTest extends BaseTest
{
    @Test
    public void test()
    {
        TablePaginationPage page= homepage1.clicktablePagination();

    }

}
