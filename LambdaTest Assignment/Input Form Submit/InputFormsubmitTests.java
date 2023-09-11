package Base;

import Pages.InputFormSubmitPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class InputFormsubmitTests extends BaseTest
{
    @Test
    public void testinputform()
    {
        InputFormSubmitPage inputform = homepage1.clickInputFormSubmit();
        inputform.enterName("tom");
        inputform.enterEmail("tom@gmail.com");
        inputform.enterAddress1("address1");
        inputform.enterAddress2("address2");
        inputform.entercity("islamabad");
        inputform.enterCompany("emumba");
        inputform.enterState("federal");
        inputform.enterZipCode("44000");
        inputform.enterWebsite("abc.com");
        inputform.enterPassword("password");
       // inputform.finddropdown();
        inputform.selectFromDropdown("Afghanistan");
        inputform.ClickSubmitButton();
        InputFormSubmitPage.InputFormValidationPage page = inputform.ClickSubmitButton();


        assertTrue(page.headerDisplay());
        assertTrue(page.messagedDisplay());
    }



}
