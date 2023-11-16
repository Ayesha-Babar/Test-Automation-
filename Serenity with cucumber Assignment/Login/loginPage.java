package Login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class loginPage extends PageObject
{
    public static Target USERNAME_FIELD=Target.the("Username field").located(By.xpath("//input[@type='email']"));
    public static Target PASSWORD_FIELD=Target.the("Password field").located(By.xpath("//input[@type='password']"));
    public static Target SUBMIT_BUTTON=Target.the("Submit button").located(By.xpath("//input[@type='submit']"));
    public static Target ERROR_MESSAGE=Target.the("Error message").located(By.id("error"));
    public static Target LOGIN_CONFIRMATION_IMAGE=Target.the("Confirmation image").located(By.xpath("//div[contains(@class,'ah-header head-options')]"));
}
