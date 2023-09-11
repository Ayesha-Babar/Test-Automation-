package Tests;

import Pages.JavascriptAlertsPage;

public class AlertTests extends BaseTest
{
    public void TestJavaScript()
    {
        JavascriptAlertsPage js= homepage.clickjavascriptAlerts();
       js.triggerAlert();
        js.acceptAlert();

        assert
    }


}
