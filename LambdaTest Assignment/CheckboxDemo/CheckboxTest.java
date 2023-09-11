package Base;
import Pages.CheckboxDemoPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
public class CheckboxTest extends BaseTest
{
    @Test
    public void CheckboxTest()
    {
        CheckboxDemoPage page= homepage1.clickcheckboxdemopage();
        // check the first checkbox
        page.clickFirstCheckBox();
        assertEquals(page.DisplayCheckedMessage(),"Checked","The message 'checked' is not displayed");

        // check the disabled checkboxes
        assertFalse( page.checkDisabled());

        // check the multiple checkbox
        // check if by clicking "Check All"; all checkboxes are checked
        page.clickCheckAllButton();
        assertTrue(page.checkClickAll());


    }
}
