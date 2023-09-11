package Base;

import Pages.JavascriptAlerts;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class AlertsTest extends BaseTest
{
    @Test
    public void JavaScriptAlertTest()
    {
        JavascriptAlerts alerts= homepage1.clickJavaScriptAlerts();
        alerts.triggerJavaScriptsAlerts();
        assertEquals("Incorrect Alert text",alerts.Javascript_AlertText(),"I am an alert box!");
        alerts.JavaScript_AcceptAlert();
    }
    @Test
    public void TestConfirmBox()
    {
        JavascriptAlerts alerts2= homepage1.clickJavaScriptAlerts();
        alerts2.triggerConfirmBox();
        alerts2.ConfirmBox_Accept();
       assertEquals("Incorrect Message",alerts2.ConfirmBoxMessage()," You pressed OK!");
       alerts2.ConfirmBox_Dismiss();
       assertEquals("Incorrect Message",alerts2.ConfirmBoxMessage(),"You pressed Cancel! ");
    }

    @Test
    public void TestPromptBox()
    {
        JavascriptAlerts alerts3= homepage1.clickJavaScriptAlerts();
        alerts3.triggerPromptBox();
        alerts3.PromptBox_InputText("Test AU");
        alerts3.ConfirmBox_Accept();
        assertEquals("Incorrect Message",alerts3.PromptBox_Message(),"Test AU");
    }

}
