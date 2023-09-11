package Base;

import Pages.DownloadFilePage;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DownloadFileTest extends BaseTest
{
    @Test
    public void FiledownloadTest()
    {
        DownloadFilePage page = homepage1.clickDownloadFile();
        page.clickDownloadFile();
        assertTrue(page.downloadConfirmation("C:\\Users\\Emumba\\Downloads")," This file is not downloaded");
    }


}
