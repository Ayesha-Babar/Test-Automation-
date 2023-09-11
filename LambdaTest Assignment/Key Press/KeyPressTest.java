package Base;


import Pages.KeyPressPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KeyPressTest extends BaseTest
{
   @Test
   public void keypresstest()
   {
      KeyPressPage page =homepage1.clickKeyPress();
      page.EnterText("abc"+ Keys.BACK_SPACE);

      assertEquals(page.GetResult(),"You entered: BACK_SPACE");
   }

   @Test
   public void PItest()
   {
      KeyPressPage page =homepage1.clickKeyPress();
      page.enterPI();
      assertEquals(page.GetResult(),"You entered: PI");
   }

}


