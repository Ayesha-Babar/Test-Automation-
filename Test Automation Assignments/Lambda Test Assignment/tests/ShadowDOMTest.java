package tests;

import pages.ShadowDOM;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ShadowDOMTest extends BaseTest
{
    @Test(groups={"smoke"},description = "Verify the basic interactions with shadow DOM elements")
    public void test()
    {
        ShadowDOM page= homepage1.clickShadowDom();
        page.shadowText();

    }

}
