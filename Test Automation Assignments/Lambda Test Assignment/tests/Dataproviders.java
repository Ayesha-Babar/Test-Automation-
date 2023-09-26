package tests;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
public class Dataproviders {
    @DataProvider(name = "Ajax form submit credentials")
    public Object[][] ajaxform() {
        return new Object[][]
                {
                        {"Ayesha", "This is a custom message"}
                };
    }

    @DataProvider(name="Bootstrap date picker2")
    public Object[][] bootstrapdate2()
    {
        return new Object[][]
                {
                        {"342007"}
                };
    }

    @DataProvider(name = "Bootstrap date picker")
    public Object[][] bootstrapdate() {
        return new Object[][]
                {
                        {"15/02/2022","20/02/2022"}
                };
    }

    @DataProvider(name = "File download")
    public Object[][] filedownload() {
        return new Object[][]
                {
                        {"This is a custom message"}
                };
    }

    @DataProvider(name = "File upload")
    public Object[][] fileupload() {
        return new Object[][]
                {
                        {"page.UploadFile(\"C:/Users/Emumba/Desktop/picture/1\")"}
                };
    }

    @DataProvider(name = "Input form submit page")
    public Object[][] inputform() {
        return new Object[][]
                {
                        {"tom","tom@gmail.com","password","emumba","abc.com","islamabad","address1","address2","federal","44000"}
                };
    }

    @DataProvider(name = "JQuery dropdown")
    public Object[][] JQuerydrop1() {
        return new Object[][]
                {
                        {"Bangladesh"}
                };
    }
    @DataProvider(name = "JQuery dropdown2")
    public Object[][] Jquerydrop2() {
        return new Object[][]
                {
                        {"Alaska","Alabama"}
                };
    }

    @DataProvider(name = "JQuery dropdown3")
    public Object[][] Jquerydrop3() {
        return new Object[][]
                {
                        {"Puerto Rico"}
                };
    }

    @DataProvider(name = "Key press")
    public Object[][] keypress() {
        return new Object[][]
                {
                        {"abc"+ Keys.BACK_SPACE}
                };
    }

    @DataProvider(name = "Key press2")
    public Object[][] keypress2() {
        return new Object[][]
                {
                        {Keys.chord(Keys.ALT,"227")+"3.14"}

                };
    }

    @DataProvider(name = "Simple Form Demo")
    public Object[][] simpleform() {
        return new Object[][]
                {
                        {"This is a custom message",4,5}

                };
    }

    @DataProvider(name = "Table data search")
    public Object[][] Tabledata() {
        return new Object[][]
                {
                        {"Development"}

                };
    }

    @DataProvider(name = "Table data search2")
    public Object[][] Tabledata2() {
        return new Object[][]
                {
                        {"1"}

                };
    }

    @DataProvider(name = "Table sort and search")
    public Object[][] Tablesort() {
        return new Object[][]
                {
                        {"A. Bennett"}

                };
    }

    @DataProvider(name = "Window popup")
    public Object[][] window() {
        return new Object[][]
                {
                        {"https://www.lambdatest.com/selenium-playground/window-popup-modal-demo"}

                };
    }

    @DataProvider(name="Data List Filter")
    public Object[][] datalist()
    {
        return new Object[][]
                {
                        {"Oakes Ltd"}
                };
    }

    @DataProvider(name="Drop Down")
    public Object[][] dropdown()
    {
        return new Object[][]
                {
                        {"Sunday"}
                };
    }

    @DataProvider(name="Drop Down2")
    public Object[][] dropdown2()
    {
        return new Object[][]
                {
                        {"California","Ohio"}
                };
    }

    @DataProvider(name="JQuery Date picker")
    public Object[][] jquery()
    {
        return new Object[][]
                {
                        {"10/15/2023"}
                };
    }

    @DataProvider(name="JQuery Date picker")
    public Object[][] jquery2()
    {
        return new Object[][]
                {
                        {"26/15/2023"}
                };
    }







}