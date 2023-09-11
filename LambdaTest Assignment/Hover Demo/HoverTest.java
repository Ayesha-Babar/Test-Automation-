package Base;
import Pages.HoverDemoPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class HoverTest extends BaseTest
{
    private By ZoomIn_Image=By.xpath("//div[@class='s__column2']//img");
    private By ZoomOut_Image=By.xpath("//div[@class='s__column3']//img");
    @Test
    public void HoverButtontest()
    {
        HoverDemoPage hover = homepage1.clickHoverdemo();

        // testing CSS Hover effects on buttons
       assertTrue(hover.HoverOverHoverMeGreenButton(),"There is no change in color of background and text on hovering over Green HoverMe button");
       assertTrue(hover.HoverBlueHoverMeButton(),"There is no change in color of background and text on hovering over Blue HoverMe button");
       assertTrue(hover.HoverLinkHover(),"The linkHover text doesn't get underlined over hovering");
       assertTrue(hover.HoverOverLastHoverMeButton(),"The color of text doesnt change");
    }

    @Test
    public void HoverImagetest()
    {
        // testing CSS Hover effect on images
        HoverDemoPage hover = homepage1.clickHoverdemo();
        assertTrue(hover.NoEffectOnlyContentShow(),"The hover message is not displayed");

        // checking zoom in and zoom out
        //scale is greater than 1 for zoom in
        assertTrue(hover.Zoom(ZoomIn_Image)>1);
        //scale is less than 1 for zoom out
        assertTrue(hover.Zoom(ZoomOut_Image)<1);



    }
}
