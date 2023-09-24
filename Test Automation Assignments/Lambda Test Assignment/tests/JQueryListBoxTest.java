package tests;

import pages.JQueryListBoxPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class JQueryListBoxTest extends BaseTest
{
    @Test(priority = 1,groups={"sanity"},description = "Test the interaction and behavior of Bootstrap list items")
    public void testAdd()
    {
        JQueryListBoxPage page= homepage1.clickJQueryListBox();
        page.AddOneElement();
        assertEquals(page.getReturnDataListCount(),1);

    }

    @Test(priority = 2,groups={"sanity"},description = "Test the interaction and behavior of Bootstrap list items")
    public void TestAddAll()
    {
        JQueryListBoxPage page= homepage1.clickJQueryListBox();
        page.AddAll();
        assertEquals("Not equal",15,page.getReturnDataListCount());

    }


    @Test(priority = 3,groups={"sanity"},description = "Test the interaction and behavior of Bootstrap list items")
    public void TestRemove()
    {
        JQueryListBoxPage page= homepage1.clickJQueryListBox();
        page.AddAll();
        page.RemoveOneElement();
        assertEquals(page.getPickDataListCount(),1);
    }

    @Test(priority = 4,groups={"sanity"},description = "Test the interaction and behavior of Bootstrap list items")
    public void TestRemoveAll()
    {
        JQueryListBoxPage page= homepage1.clickJQueryListBox();
        page.AddAll();
        page.RemoveAll();
        assertEquals(page.getPickDataListCount(),15);

    }



}
