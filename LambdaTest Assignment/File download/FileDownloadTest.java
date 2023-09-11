package Base;

import Pages.FileDownloadPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest
{
    @Test
    public void filedownloadtest()
    {
        FileDownloadPage page= homepage1.clickFileDownload();
        page.Entertext("This is a custom message");
        assertTrue(page.CharactersRemainingMessage());
        assertEquals(page.GetCharactersRemainingMessage(),"476 characters remaining");

        page.clickGenerateFileButton();
       page.clickDownloadFileLink();
       assertTrue(page.downloadConfirmation("C:\\Users\\Emumba\\Downloads"));
    }
}
