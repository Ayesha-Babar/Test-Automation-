package Login;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;


public class loginActions
{
    Actor actor= Actor.named("user");
    public static Performable enterUsername(String username)
    {
        return Enter.theValue(username).into(loginPage.USERNAME_FIELD);
    }

    public static Performable enterPassword(String password)
    {
        return Enter.theValue(password).into(loginPage.PASSWORD_FIELD);
    }


    public static Performable ClickSubmit() {
        return Click.on(loginPage.SUBMIT_BUTTON);
    }

    public static Performable loginWithCredentialsFromJSON(String JSONfilePath) {
        return Task.where("{0} attempts to log in with credentials from JSON file",
                actor -> {
                    try {
                        Gson gson = new Gson();
                        JsonObject jsonObject = JsonParser.parseReader(new FileReader(JSONfilePath)).getAsJsonObject();
                        String username = jsonObject.get("valid username").getAsString();
                        String password = jsonObject.get("valid password").getAsString();

                        actor.attemptsTo(
                                enterUsername(username),
                                enterPassword(password),
                                ClickSubmit()
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

    }

    }









