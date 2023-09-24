package tests;

import pages.SimpleFormDemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFormDemoPageTests extends BaseTest{

    @Test(dataProvider = "Simple Form Demo",dataProviderClass = Dataproviders.class,groups={"smoke","sanity"},description = "Verify the basic functionality of submitting forms and test submissions with valid and invalid inputs")
    public void formdemotest(String message, int firstval, int secondval){

        SimpleFormDemoPage formdemopage = homepage1.clickSimpleFormDemo();

        formdemopage.EnterMessage(message);
        formdemopage.clickGetCheckedValue();
        Assert.assertEquals(message,formdemopage.getDisplayMessageOutput());

        formdemopage.EnterFirstValue(firstval);
        formdemopage.EnterSecondValue(secondval);
        formdemopage.clickGetSum();
        formdemopage.getSumDisplayed();
        Assert.assertEquals(formdemopage.getSumDisplayed(),9);
    }
}
