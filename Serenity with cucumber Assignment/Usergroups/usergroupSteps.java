package Usergroups;

import Login.loginActions;
import Users.userActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Users.userPage.IAM_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class usergroupSteps {
    private WebDriver driver;
    private Actor user;




    @Given("The user is on user groups page")
    public void givenTheUserIsOnTheUsergroupPage() {
        user = Actor.named("User");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emumba\\Desktop\\Serenity_yt\\loginpractice\\src\\test\\java\\new chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        user.can(BrowseTheWeb.with(driver));
        user.attemptsTo(Open.url("https://ztna1.qa.xcloudiq.com/login"));
        user.attemptsTo(loginActions.loginWithCredentialsFromJSON("C:\\Users\\Emumba\\Desktop\\Serenity_yt\\loginpractice\\src\\test\\java\\credentials.json"));
        user.can(BrowseTheWeb.with(driver));
        user.attemptsTo(Open.url("https://feature-2.qa.xcloudiq.com/zta"));
        WebElement iamButton = IAM_BUTTON.resolveFor(user);
        WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(user).getDriver(), Duration.ofSeconds(10)); // Adjust the timeout as needed

        // Use the resolved WebElement for the wait
        wait.until(ExpectedConditions.visibilityOf(iamButton));

        user.attemptsTo(userActions.ClickIAM());
        user.attemptsTo(userGroupActions.ClickUserGroupOption());
        user.attemptsTo(userGroupActions.ClickAddUserGroupButton());
    }

    @When("The user creates a usergroup with a name and selects users")
    public void whenTheUserEntersValidCredentials() {

        user.attemptsTo(userGroupActions.AddUserGroup("demo2"));
    }

    @Then("The user group should be present in the list of user groups")
    public void userGroupShouldBePresent() {
        List<WebElement> UserGroupList=driver.findElements(By.xpath("//td[@id='RowCell-name-0']"));
        boolean isPresent = userGroupQuestions.checkTextInWebElements(UserGroupList, "demo2");
        Ensure.that(isPresent).isTrue();
    }


}
