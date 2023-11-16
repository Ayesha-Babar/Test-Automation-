package Users;

import Login.loginActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Users.userPage.IAM_BUTTON;
import static net.serenitybdd.screenplay.actions.Switch.toFrame;


public class userSteps {
    private WebDriver driver;
        private Actor user;


        @Given("the user is on feature page")
        public void givenTheUserIsOnThefeaturePage()
        {
            user=Actor.named("User");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emumba\\Desktop\\Serenity_yt\\loginpractice\\src\\test\\java\\new chromedriver\\chromedriver.exe");
            driver= new ChromeDriver();
            user.can(BrowseTheWeb.with(driver));
            user.attemptsTo(Open.url("https://ztna1.qa.xcloudiq.com/login"));
            user.attemptsTo(loginActions.loginWithCredentialsFromJSON("C:\\Users\\Emumba\\Desktop\\Serenity_yt\\loginpractice\\src\\test\\java\\credentials.json"));
            user.can(BrowseTheWeb.with(driver));
            user.attemptsTo(Open.url("https://feature-2.qa.xcloudiq.com/zta"));



        }

        @When("the user clicks the IAM button")
        public void whentheUserclicksTheIAMbutton()
        {
            WebElement iamButton = IAM_BUTTON.resolveFor(user);

            WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(user).getDriver(), Duration.ofSeconds(10)); // Adjust the timeout as needed

            // Use the resolved WebElement for the wait
            wait.until(ExpectedConditions.visibilityOf(iamButton));


            user.attemptsTo(userActions.GoToIAMPage());
        }

        @When("clicks the user button")
        public void AndClickstheuserButton()
        {
            user.attemptsTo(userActions.GoToUsersPage());
        }
        @When("clicks the invite users button")
        public void AndClicksTheinviteusersbutton()
        {

            user.attemptsTo(userActions.ClickInviteUsers());


        }

    @When("Enters email to send invite")
    public void AndEntersEmailToSendInvite() {
            user.attemptsTo(
                userActions.InviteuserswithEmailFromJSON("C:\\Users\\Emumba\\Desktop\\Serenity_yt\\loginpractice\\src\\test\\java\\credentials.json"),
                userActions.ClickSendInvitation());



    }



        @Then("the new user should be added in the users list")
        public void thenTheUserShouldBeAddedIntheList() {

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            List<WebElement> USER_LIST= driver.findElements(By.xpath("//tbody//tr//td[@id='RowCell-email-0']"));

                    Ensure.that(userQuestions.inList("ayesha@gmail.com", USER_LIST )).isTrue();

        }


     }



