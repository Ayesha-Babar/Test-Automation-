package Base;

import Pages.ContextMenuPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ContextMenuTest extends BaseTest
{
    @Test
    public void test()
    {
        ContextMenuPage page= homepage1.clickcontextMenu();
        page.contextClick();
        assertEquals(page.GetAlertText(),"You selected a context menu");
        page.clickOk();
    }
}
