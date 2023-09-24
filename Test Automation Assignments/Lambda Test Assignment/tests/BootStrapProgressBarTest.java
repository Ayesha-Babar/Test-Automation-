package tests;

import pages.BootstrapDownloadProgressBarPage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class BootStrapProgressBarTest extends BaseTest
{
    @Test(groups={"smoke","sanity"},description="Verify that Bootstrap progress bars display and update correctly")
    public void testBootstrapprogress()
    {
        BootstrapDownloadProgressBarPage page= homepage1.clickBootstrapProgressBar();
        page.clickStartDownload();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Set a 10-second implicit wait

        assertTrue(page.DownloadConfirmation());
    }


}
