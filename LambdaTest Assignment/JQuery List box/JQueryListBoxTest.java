package Base;

import Pages.JQueryListBoxPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class JQueryListBoxTest extends BaseTest
{
    @Test
    public void testAdd()
    {
        JQueryListBoxPage page= homepage1.clickJQueryListBox();
        page.AddOneElement();
        assertEquals(page.getReturnDataListCount(),1);

    }

    @Test
    public void TestAddAll()
    {
        JQueryListBoxPage page= homepage1.clickJQueryListBox();
        page.AddAll();
        assertEquals("Not equal",8,page.getReturnDataListCount());

    }

    @Test
    public void TestRemove()
    {
        JQueryListBoxPage page= homepage1.clickJQueryListBox();
        page.AddAll();
        page.RemoveOneElement();
        assertEquals(page.getPickDataListCount(),1);
    }

    @Test
    public void TestRemoveAll()
    {
        JQueryListBoxPage page= homepage1.clickJQueryListBox();
        page.AddAll();
        page.RemoveAll();
        assertEquals(page.getPickDataListCount(),8);

    }



}
