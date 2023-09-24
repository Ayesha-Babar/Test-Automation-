package tests;

import pages.InputFormSubmitPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class InputFormsubmitTests extends BaseTest
{
    @Test(dataProvider = "Input form submit page", dataProviderClass = Dataproviders.class,groups={"smoke","sanity"},description = "Verify the basic functionality of submitting input forms and Test form submissions with valid and invalid inputs")
    public void testinputform(String name,String email, String password,String company, String website,String city,String address1,String address2,String state,String code)
    {
        InputFormSubmitPage inputform = homepage1.clickInputFormSubmit();
        inputform.Fillfields(name,email,password,company,website,city,address1,address2,state,code);


        inputform.selectFromDropdown("Afghanistan");

        InputFormSubmitPage.InputFormValidationPage page = inputform.ClickSubmitButton();


        assertTrue(page.headerDisplay());
        assertTrue(page.messagedDisplay());
    }



}
