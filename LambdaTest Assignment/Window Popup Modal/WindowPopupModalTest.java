package Base;

import Pages.WindowPopupModalPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class WindowPopupModalTest extends BaseTest
{
    @Test
    public void testFollowOnTwitter()
    {
        WindowPopupModalPage page= homepage1.clickWindowPopup();
        page.FetchTheWindowHandle();
        page.clickFollowOnTwitter();
        assertEquals(page.GetWindowHandlesSize(),2);
    }

    @Test
    public void testLikeusOnFacebook()
    {
        WindowPopupModalPage page= homepage1.clickWindowPopup();
        page.clickLikeonFacebook();
        assertEquals(page.GetWindowHandlesSize(),2);
    }

    @Test
    public void testFollowusonLinkedin()
    {
        WindowPopupModalPage page= homepage1.clickWindowPopup();
        page.clickLinkedin();
        assertEquals(page.GetWindowHandlesSize(),2);
    }

    @Test
    public void testOpenURL()
    {
        WindowPopupModalPage page= homepage1.clickWindowPopup();
        page.OpenURL();
        assertEquals(page.OpenURL(),"https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");

    }

    @Test
    public void TestfollowFacebookandTwitter()
    {
        WindowPopupModalPage page= homepage1.clickWindowPopup();
        assertEquals(page.clickFollowTwitterandFacebook(),2);

    }





}
