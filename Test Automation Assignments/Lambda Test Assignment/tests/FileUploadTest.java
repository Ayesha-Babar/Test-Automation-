package tests;
import pages.FileUploadPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUploadTest extends BaseTest
{
    @Test(dataProvider = "File upload",dataProviderClass = Dataproviders.class,groups={"smoke","sanity"},description = "Verify that the files can be downloaded correctly and test file formats")
    public void UploadFiletest(String path)
    {
        FileUploadPage page= homepage1.clickUploadFileDemo();
        page.UploadFile(path);
        assertEquals(page.GetUploadConfirmation(),"File Successfully Uploaded");

    }

}
