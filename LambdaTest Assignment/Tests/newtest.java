package Base;

import Pages.SliderDemoPage;
import org.testng.annotations.Test;

public class newtest extends BaseTest
{
    @Test
    public void testDragandDrop()
    {
        SliderDemoPage sliderdemopage= homepage1.clickDragandDrop();
        sliderdemopage.SetSlidervalue(2,5);

    }


}

