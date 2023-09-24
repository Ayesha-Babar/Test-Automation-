package tests;

import pages.VirtualDOM;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class VirtualDOMTest extends BaseTest
{
    @Test(groups = "smoke",description = "Verify basic interactions and rendering with a virtual DOM")
    public void test()
    {
        VirtualDOM page = homepage1.clickVirtualDom();
        System.out.println(page.GetTime());
        System.out.println(page.Time());
       assertTrue(page.ConfirmTime());
    }
}
