package tests;

import pages.DynamicDataLoadingPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class DynamicDataLoadingTest extends BaseTest
{

    @Test(groups = {"smoke"},description = "Verify that dynamic data loads correctly.")
    public void test()
    {
        DynamicDataLoadingPage page= homepage1.clickDynamicDataLoading();
        page.clickGetRandomUser();
        assertTrue(page.isBoxDisplayed());
    }

}
