package tests;

import pages.ProgressBarModalPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ProgressBarModalTest extends BaseTest
{
    @Test(priority = 1,groups={"smoke,sanity"},description="Verify that progress bar modals open and close as expected.Also Test the content and interactions within progress bar modals")
    public void test()
    {
        ProgressBarModalPage page= homepage1.clickProgressBarModal();
        page.clickShowDialogForTwoSec();
        assertTrue(page.ModalDisplayTwoSeconds());
    }

    @Test(priority = 2,groups={"smoke","sanity"},description="Verify that progress bar modals open and close as expected.Also Test the content and interactions within progress bar modals")
    public void test2()
    {
        ProgressBarModalPage page= homepage1.clickProgressBarModal();
        page.clickShowDialogThreeseconds();
        assertTrue(page.ModalDisplayThreeSeconds());
        assertTrue(page.GetModalTextThreeSeconds().contains("Custom message"));
    }

    @Test(priority = 3,groups={"smoke","sanity"},description="Verify that progress bar modals open and close as expected.Also Test the content and interactions within progress bar modals")
    public void test3()
    {
        ProgressBarModalPage page= homepage1.clickProgressBarModal();
        page.clickShowDialogFiveSeconds();
        assertTrue(page.ModalDisplayFiveSeconds());
       assertTrue( page.GetModalTextFiveSeconds().contains("Hello Mr. Alert !"));
    }
}
