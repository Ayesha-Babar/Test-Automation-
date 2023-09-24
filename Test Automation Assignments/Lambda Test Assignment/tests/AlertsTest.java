package tests;

import pages.JavascriptAlerts;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class AlertsTest extends BaseTest
{
    @Test(priority = 1,groups={"smoke,sanity"},description = "Verify basic Alert functionality and test alert appearance and dismissal")
    public void JavaScriptAlertTest()
    {
        JavascriptAlerts alerts= homepage1.clickJavaScriptAlerts();
        alerts.triggerJavaScriptsAlerts();
        assertEquals(alerts.AlertText(),"I am an alert box!","incorrect text message");
        alerts.AcceptAlert();
    }
    @Test(priority = 2,groups={"smoke","sanity"},description = "Verify basic Alert functionality and test alert appearance and dismissal")
    public void TestConfirmBox()
    {
        JavascriptAlerts alerts2= homepage1.clickJavaScriptAlerts();
        alerts2.triggerConfirmBox();

        alerts2.AcceptAlert();
        assertEquals(alerts2.ConfirmBoxMessage(),"You pressed OK!","incorrect message");


    }

    @Test(priority = 3,groups={"smoke","sanity"},description = "Verify basic Alert functionality and test alert appearance and dismissal")
    public void TestPromptBox()
    {
        JavascriptAlerts alerts3= homepage1.clickJavaScriptAlerts();
        alerts3.triggerPromptBox();
        alerts3.PromptBox_InputText("Test AU");
        alerts3.AcceptAlert();
        assertEquals(alerts3.PromptBox_Message(),"You have entered 'Test AU' !","incorrect message");
    }

}
