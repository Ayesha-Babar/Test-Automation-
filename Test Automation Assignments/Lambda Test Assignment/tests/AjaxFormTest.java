package tests;

import org.testng.annotations.Test;
import pages.AjaxFormSubmitPage;

import static org.testng.Assert.assertTrue;

public class AjaxFormTest extends BaseTest
{
    @Test(dataProvider = "Ajax form submit credentials",dataProviderClass = Dataproviders.class,groups={"regression"},description = "Test various inputs and AJAX inetarctions in this form")
    public void AjaxTest(String name, String message)
    {
        AjaxFormSubmitPage page= homepage1.clickAjaxFormSubmit();
        page.EnterName(name);
        page.EnterMessage(message);
        page.ClickSubmit();
        assertTrue(page.SubmitConfirmation(),"The message is not displayed");
    }

}
