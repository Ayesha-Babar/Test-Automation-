package Tests;

import Pages.HoverPage;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HoverTest extends BaseTest
{
    @Test
    public void testHoverpage()
    {
        var hoverpage=homepage.clickHover();
        HoverPage.FigureCaption caption= hoverpage.hoveroverFigure(1);
      assertTrue("Caption not displayed",caption.isCaptionDisplayed());
      assertEquals(caption.GetTitle(),"user1");
      assertEquals(caption.getLinkText(),"View profile");
      assertTrue(caption.getLinkText().endsWith("/users/1"));


    }
}
