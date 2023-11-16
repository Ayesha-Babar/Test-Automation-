package Users;

import Login.loginPage;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;


public class userActions
{
    public static Performable Clickusers()
    {
        return Click.on(userPage.USERS_BUTTON);
    }


    public static Performable InviteuserswithEmailFromJSON(String JSONfilePath) {

        return Task.where("{0} attempts to invite a user with email from JSON file",
                actor -> {
                    try {
                        Gson gson = new Gson();
                        JsonObject jsonObject = JsonParser.parseReader(new FileReader(JSONfilePath)).getAsJsonObject();
                        String email = jsonObject.get("email").getAsString();


                        actor.attemptsTo(
                                Enter.theValue(email).into(userPage.EMAIL_FIELD),
                                Click.on(userPage.DROPDOWN)


                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    public static Performable ClickIAM() {
        return Task.where("{0} clicks the IAM button", actor -> {
            WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(10));
            Target IAM_BUTTON = Target.the("IAM button").located(By.xpath("//div[@title='IAM']"));
            wait.until(ExpectedConditions.elementToBeClickable(IAM_BUTTON.resolveFor(actor)));
            actor.attemptsTo(Click.on(IAM_BUTTON));
        });
    }


    public static Performable ClickSendInvitation()
    {
        return Task.where("{0} clicks the Send Invitation button", actor -> {

           WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(20));
           wait.until(ExpectedConditions.elementToBeClickable(userPage.SEND_INVITATION_BUTTON.resolveFor(actor)));
            actor.attemptsTo(
                    Click.on(userPage.SEND_INVITATION_BUTTON)
            );
        });
    }


    public static Performable GoToIAMPage() {
        return Task.where("{0} attempts to go to the IAM page",
                actor -> {
                    actor.attemptsTo(
                            userActions.ClickIAM()

                    );
                });
    }

    public static Performable GoToUsersPage() {
        return Task.where("{0} attempts to go to the users page",
                actor -> {
                    actor.attemptsTo(
                            userActions.Clickusers()

                    );
                });
    }

    public static Performable ClickInviteUsers() {
        return Task.where("{0} attempts to click invite users button",
                actor -> {
                    actor.attemptsTo(
                            Click.on(userPage.INVITE_USERS_BUTTON)

                    );
                });
    }

    public static Performable DeleteUser()
    {
        return Task.where("{0} deletes the newly created user",
                actor -> {
            actor.attemptsTo(
                    Click.on(userPage.THREE_DOT_MENU));
                });

    }







}
