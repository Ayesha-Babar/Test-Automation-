package tests;

import pages.RedirectionPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertFalse;

public class RedirectionTest extends BaseTest
{
    @Test(groups = {"smoke"},description = "Verify that the URL redirections work as expected")
    public void test()
    {
        RedirectionPage page= homepage1.clickRedirection();
        String InitialURL= page.GetCurrentURL();
        page.clickHere();
        String FinalURL= page.GetCurrentURL();
        System.out.println(InitialURL);
        System.out.println(FinalURL);

        assertNotEquals(InitialURL,FinalURL);

    }

}
