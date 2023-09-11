package Base;
import Pages.FileUploadPage;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUploadTest extends BaseTest
{
    @Test
    public void UploadFiletest()
    {
        FileUploadPage page= homepage1.clickUploadFileDemo();
        page.UploadFile("C:\\Users\\Emumba\\Pictures\\1");
        assertEquals("The file is not uploaded",page.GetUploadConfirmation(),"File Successfully Uploaded");

    }

}
