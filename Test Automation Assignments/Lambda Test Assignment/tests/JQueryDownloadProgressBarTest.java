package tests;

import pages.JQueryDownloadProgressBarPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JQueryDownloadProgressBarTest extends BaseTest
{
    @Test(groups={"smoke","sanity"},description="Verify that JQuery progress bars display and update correctly")
    public void jqueryTest()
    {
        JQueryDownloadProgressBarPage page = homepage1.clickJqueryBar();
        page.clickStartDownload();
        assertTrue(page.WaitForProgressBarTocomplete(),"The message is not displayed");

    }

}
