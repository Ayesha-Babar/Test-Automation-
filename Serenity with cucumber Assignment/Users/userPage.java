package Users;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class userPage

{


    public static Target IAM_BUTTON=Target.the("IAM button").located(By.xpath("//div[@title='IAM']"));
    public static Target USERS_BUTTON=Target.the("Users button").located(By.xpath("//span[text()='Users']"));
    public static Target INVITE_USERS_BUTTON=Target.the("Invite button").located(By.xpath("//span[text()='Invite Users']"));
    public static Target EMAIL_FIELD=Target.the("Email field").located(By.xpath("//input[@placeholder='Enter email addresses of new team members']"));
    public static Target SEND_INVITATION_BUTTON=Target.the("Send invitation button").located(By.xpath("//span[text()='Send Invitation']"));
    public static Target DROPDOWN= Target.the("dropdown").located(By.xpath("//div[contains(@class,'react-select__indicators')]"));
    public static Target THREE_DOT_MENU=Target.the("Three dot menu").located(By.xpath("//td//button[contains(@id,'TableRow-3')]"));
}
