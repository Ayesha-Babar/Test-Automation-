package tests;

import pages.BootstrapListPage;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class BootstrapListTest  extends BaseTest
{
    @Test(groups={"smoke"},description = "Verify the basic functionality and appearance of bootstrap styled lists")
    public void test()
    {
        BootstrapListPage page= homepage1.clickBootstrapList();
        Dimension initialsize=page.GetSizeOfList();
        page.SelectTheElement();
        page.ClickRight();
        Dimension finalsize=page.GetSizeOfList();
        page.getRightListElements();
        assertNotEquals(initialsize,finalsize);
    }
}
