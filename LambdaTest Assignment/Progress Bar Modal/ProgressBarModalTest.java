package Base;

import Pages.ProgressBarModalPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ProgressBarModalTest extends BaseTest
{
    @Test
            public void test()
    {
        ProgressBarModalPage page= homepage1.clickProgressBarModal();
        page.clickShowDialogForTwoSec();
        assertTrue(page.ModalDisplayTwoSeconds());
    }

    @Test
    public void test2()
    {
        ProgressBarModalPage page= homepage1.clickProgressBarModal();
        page.clickShowDialogThreeseconds();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // assertTrue(page.ModalDisplayThreeSeconds());
        assertEquals(page.GetModalTextThreeSeconds(),"Custom message");
    }

    @Test
    public void test3()
    {
        ProgressBarModalPage page= homepage1.clickProgressBarModal();
        page.clickShowDialogFiveSeconds();
        assertTrue(page.ModalDisplayFiveSeconds());
       assertEquals( page.GetModalTextFiveSeconds(),"Hello Mr. Alert!");
    }
}
