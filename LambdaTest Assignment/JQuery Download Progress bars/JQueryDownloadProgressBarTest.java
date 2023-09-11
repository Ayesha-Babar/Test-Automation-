package Base;

import Pages.JQueryDownloadProgressBarPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JQueryDownloadProgressBarTest extends BaseTest
{
    @Test
    public void jqueryTest()
    {
        JQueryDownloadProgressBarPage page = homepage1.clickJqueryBar();
        page.clickStartDownload();
        assertTrue(page.WaitForProgressBarTocomplete(),"The complete message is not displayed");

    }

}
