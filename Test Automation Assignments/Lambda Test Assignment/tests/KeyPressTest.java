package tests;


import pages.KeyPressPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KeyPressTest extends BaseTest
{
   @Test(dataProvider = "Key press",dataProviderClass = Dataproviders.class,priority = 1,groups={"smoke","sanity"},description = "Verify that keypress events are detected and processed and test keypress interactions,shortcuts and special keys ")
   public void keypresstest(String text)
   {
      KeyPressPage page =homepage1.clickKeyPress();
      page.EnterText(text);
      assertEquals(page.GetResult(),"You entered: BACK_SPACE");
   }

   @Test(dataProvider = "Key press2",dataProviderClass = Dataproviders.class,priority = 2,groups={"smoke","sanity"},description = "Verify that keypress events are detected and processed and test keypress interactions,shortcuts and special keys ")
   public void PItest(String key)
   {
      KeyPressPage page =homepage1.clickKeyPress();
      page.enterPI(key);
      assertEquals(page.GetResult(),"You entered: 4");
   }

}


