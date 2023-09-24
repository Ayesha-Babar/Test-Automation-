package tests;

import pages.BootstrapModalPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class BootstrapModalTest extends BaseTest
{
    @Test(priority = 1,groups={"smoke","sanity"},description="Verify that Bootstrap modals open and close as expected.Also Test the content and interactions within Bootstrap modals")
    public void test()
    {
        BootstrapModalPage page= homepage1.clickBootstrapModal();
        page.clickLaunchModal(0);
        assertEquals("This is the place where the content for the modal dialog displays",page.GetcontentModal());
        page.clickSave(0);

    }

    @Test(priority = 2,groups={"smoke","sanity"},description="Verify that Bootstrap modals open and close as expected.Also Test the content and interactions within Bootstrap modals")
    public void testMultipleModal()
    {
        BootstrapModalPage page= homepage1.clickBootstrapModal();
        page.clickLaunchModal(1);
        assertTrue(page.GetContentMultipleModal().contains("This is the place where the content for the modal dialog displays"));

        page.clickLaunchModal(2);
        assertTrue(page.GetContentSecondMultiModal().contains("This is the place where the content for the modal dialog displays"));

        page.clickSave(2);
        page.clickSave(1);


    }

}
