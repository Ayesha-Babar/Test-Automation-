package Base;

import Pages.BootstrapModalPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class BootstrapModalTest extends BaseTest
{
    @Test
    public void test()
    {
        BootstrapModalPage page= homepage1.clickBootstrapModal();
        page.clicklaunchButton(1);
        assertEquals(page.GetcontentFirstModal(),"This is the place where the content for the modal dialog displays");
    }

    @Test
    public void test2()
    {
        BootstrapModalPage page= homepage1.clickBootstrapModal();
        page.clicklaunchButton(2);



    }

}
