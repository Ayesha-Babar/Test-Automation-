package Base;

import Pages.SimpleFormDemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFormDemoPageTests extends BaseTest{

    @Test
    public void formdemotest(){

        SimpleFormDemoPage formdemopage = homepage1.clickSimpleFormDemo();
        String message="This is a custom message";
        formdemopage.EnterMessage(message);
        formdemopage.clickGetCheckedValue();
        Assert.assertEquals(message,formdemopage.getDisplayMessageOutput());

        formdemopage.EnterFirstValue(3);
        formdemopage.EnterSecondValue(4);
        formdemopage.clickGetSum();
        formdemopage.getSumDisplayed();
        Assert.assertEquals(formdemopage.getSumDisplayed(),7);
    }
}
