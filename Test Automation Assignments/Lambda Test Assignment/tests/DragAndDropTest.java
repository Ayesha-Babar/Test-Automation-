package tests;

import pages.DragAndDropPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DragAndDropTest extends BaseTest
{
    @Test(groups={"sanity","smoke"},description="Verify basic drag-and-drop functionality and Test drag-and-drop interactions with different elements")
    public void test()
    {
        DragAndDropPage page= homepage1.clickDragAndDrop();
        page.DragAndDrop();
        page.DragAndDrop2();
        assertEquals(page.getText(),"Dropped!");

    }

}
