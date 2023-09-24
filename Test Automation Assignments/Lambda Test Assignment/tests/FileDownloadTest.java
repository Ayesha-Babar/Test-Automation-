package tests;

import pages.FileDownloadPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest
{
    @Test(dataProvider = "File download",dataProviderClass = Dataproviders.class,groups={"smoke","sanity"},description = "Verify that the files can be downloaded correctly and test file formats")
    public void filedownloadtest(String message)
    {
        FileDownloadPage page= homepage1.clickFileDownload();
        page.Entertext(message);
        assertTrue(page.CharactersRemainingMessage());
        assertEquals(page.GetCharactersRemainingMessage(),"476 characters remaining");

        page.clickGenerateFileButton();
       page.clickDownloadFileLink();
       assertTrue(page.downloadConfirmation("C:\\Users\\Emumba\\Downloads"));
    }
}
