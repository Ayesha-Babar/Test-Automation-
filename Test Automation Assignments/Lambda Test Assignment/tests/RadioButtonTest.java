package tests;

import pages.RadioButtonDemoPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class RadioButtonTest extends BaseTest
{
   @Test(priority = 1,groups={"smoke","sanity"},description = "Verify the basic functionality of radio buttons and test their interactions")
   public void test()
   {
      RadioButtonDemoPage page= homepage1.clickRadioButton();
      page.clickFirstRadioButton();
      page.confirmationClick();
   }

   @Test(priority = 2,groups={"smoke","sanity"},description = "Verify the basic functionality of radio buttons and test their interactions")
   public void testDisabled()
   {
      RadioButtonDemoPage page= homepage1.clickRadioButton();
      assertTrue(page.CheckDisabled());
   }

   @Test(priority = 3,groups={"smoke","sanity"},description = "Verify the basic functionality of radio buttons and test their interactions")
   public void confirmation()
   {
      RadioButtonDemoPage page= homepage1.clickRadioButton();
      page.ClickAgeandGender();
      page.clickgetValue();
      assertEquals("Male",page.genderConfirmation());
      assertEquals("5 - 15",page.ageconfirmation());
   }


}
