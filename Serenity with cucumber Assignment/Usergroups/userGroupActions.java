package Usergroups;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.WebElementLocator;

import java.util.List;

import static net.serenitybdd.screenplay.Task.where;

public class userGroupActions
{


    public static Performable selectUserFromDropdown(String option) {
        return where(
                "{0} selects the user '{1}' from the dropdown",
                actor -> actor.attemptsTo(
                        Click.on(userGroupPage.USERS_DROPDOWN),
                        Click.on(userGroupPage.USERS_DROPDOWN.of(option))
                )
        );
    }

    public static Performable ClickUserGroupOption()
    {
        return Click.on(userGroupPage.USER_GROUO_OPTION);
    }
    public static Performable ClickAddUserGroupButton() {
        return Click.on(userGroupPage.ADD_USER_GROUP_BUTTON);
    }

   public static Performable EnterUserGroupName(String usergroupname)
   {
       return Enter.theValue(usergroupname).into(userGroupPage.NAME_FIELD);
   }


    public static Performable AddUserGroup(String userGroupName) {

        return Task.where("{0} adds a user group with name userGroupName and selects users ",
                actor -> {
                    actor.attemptsTo(
                            userGroupActions.EnterUserGroupName(userGroupName),
                            Click.on(userGroupPage.USERS_DROPDOWN),
                            Click.on(userGroupPage.ADD_BUTTON),
                            Click.on(userGroupPage.CREATE_BUTTON)


                    );
                });
    }
}

