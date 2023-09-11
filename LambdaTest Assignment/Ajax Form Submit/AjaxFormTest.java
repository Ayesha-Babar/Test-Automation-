package Base;

import Pages.AjaxFormSubmitPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class AjaxFormTest extends BaseTest
{
    @Test
    public void AjaxTest()
    {
        AjaxFormSubmitPage page= homepage1.clickAjaxFormSubmit();
        page.EnterName("Ayesha");
        page.EnterMessage("This is a custom message");
        page.ClickSubmit();
        assertTrue(page.SubmitConfirmation(),"The message is not displayed");
    }

}
