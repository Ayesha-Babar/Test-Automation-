package Usergroups;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;

public class userGroupPage
{
    public static Target ADD_USER_GROUP_BUTTON=Target.the("Usergroup button").located(By.xpath("//span[text()='Create User Group']"));
    public static Target USER_GROUO_OPTION=Target.the("User group option").located(By.xpath("//span[text()='User Groups']"));
    public static Target NAME_FIELD=Target.the("Name field").located(By.xpath("//input[@id='en-ztna-addAccessGroup-name']"));
    public static Target USERS_DROPDOWN=Target.the("Users drop down").located(By.xpath("//div[contains(@class,'dropdown')]"));
    public static Target ADD_BUTTON=Target.the("Add all button").located(By.xpath("//p[text()='Add' and @id='en-ztna-addAccessGroup-selectUserButton' and @data-testid='addUserToAccessGroup-Select All']"));
    public static Target CREATE_BUTTON=Target.the("Create user group button").located(By.xpath("//button[@id='en-ztna-modal-saveButton']"));

}
