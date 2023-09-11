package Base;

import Pages.RedirectionPage;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.*;
import static org.testng.AssertJUnit.assertFalse;

public class RedirectionTest extends BaseTest
{
    @Test
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
