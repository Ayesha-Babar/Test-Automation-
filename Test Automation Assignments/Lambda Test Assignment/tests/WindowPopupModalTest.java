package tests;

import pages.WindowPopupModalPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class WindowPopupModalTest extends BaseTest
{
    @Test(priority = 1,groups={"smoke"},description = "Verify that window popups and modals open and close as expected")
    public void testSinglePopup()
    {
        WindowPopupModalPage page= homepage1.clickWindowPopup();
        page.clickLikeonFacebook();
        assertEquals(2,page.GetWindowHandlesSize());

        page.clickLinkedin();
        assertEquals(2,page.GetWindowHandlesSize());

        page.clickFollowOnTwitter();
        assertEquals(2,page.GetWindowHandlesSize());

    }

    @Test(dataProvider = "Window popup",dataProviderClass = Dataproviders.class,priority = 2,groups={"smoke"},description = "Verify that window popups and modals open and close as expected")
    public void testURL(String url)
    {
        WindowPopupModalPage page= homepage1.clickWindowPopup();
        assertEquals("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo",page.OpenURL(url));


    }

    @Test(priority = 3,groups={"smoke"},description = "Verify that window popups and modals open and close as expected")
    public void testMultiplePopups()
    {
        WindowPopupModalPage page= homepage1.clickWindowPopup();
        assertEquals(3,page.clickFollowTwitterandFacebook());

        assertEquals(4,page.ClickFollowAll());
    }



}
