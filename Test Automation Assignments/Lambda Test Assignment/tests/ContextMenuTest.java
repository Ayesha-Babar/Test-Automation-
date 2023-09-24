package tests;

import pages.ContextMenuPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ContextMenuTest extends BaseTest
{
    @Test(groups={"smoke","sanity"},description = "Verify the appearance and basic functionality of context menus an test their interactions")
    public void test()
    {
        ContextMenuPage page= homepage1.clickcontextMenu();
        page.contextClick();
        assertEquals(page.GetAlertText(),"You selected a context menu");
        page.clickOk();
    }
}
