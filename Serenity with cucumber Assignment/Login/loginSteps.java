package Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginSteps
{

    @Managed
    private WebDriver driver;
    private Actor user;



    @Given("the user is on the login page")
    public void givenTheUserIsOnTheLoginPage()
    {
        user=Actor.named("User");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emumba\\Desktop\\Serenity_yt\\loginpractice\\src\\test\\java\\new chromedriver\\chromedriver.exe");
        driver= new ChromeDriver();
        user.can(BrowseTheWeb.with(driver));
        user.attemptsTo(Open.url("https://ztna1.qa.xcloudiq.com/login"));

    }

    @When("the user enters valid credentials")
    public void whenTheUserEntersValidCredentials()
    {
        user.attemptsTo(loginActions.loginWithCredentialsFromJSON("C:\\Users\\Emumba\\Desktop\\Serenity_yt\\loginpractice\\src\\test\\java\\credentials.json"));

    }


    @Then("the user should be logged in")
    public void thenTheUserShouldBeLoggedIn() {
        Ensure.that(loginQuestions.displayed()).isTrue();
    }
}
