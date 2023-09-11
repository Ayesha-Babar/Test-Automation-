package Tests;

import Pages.KeyPressPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KeypressTest extends BaseTest
{
    @Test
            public void testbackspace()
    {
        KeyPressPage key= homepage.clickKeypress();
        key.enterText("A"+ Keys.BACK_SPACE);

       assertEquals(key.getResult(),"You entered: BACK_SPACE");

    }
     @Test
    public void testPi()
     {
         var keypage= homepage.clickKeypress();
         keypage.enterPI();


     }
}
