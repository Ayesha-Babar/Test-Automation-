package Login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class loginQuestions implements Question<Boolean>{


    public static boolean waitForAndCheckVisibility(Actor actor, By elementLocator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(actor.abilityTo(BrowseTheWeb.class).getDriver(), Duration.ofSeconds(timeoutInSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return element.isDisplayed();
    }
    @Override
    public Boolean answeredBy(Actor actor) {

        boolean isElementDisplayed = waitForAndCheckVisibility(actor, By.xpath("//div[contains(@class,'ah-header head-options')]"), 10);
        System.out.println("Is the element displayed? " + isElementDisplayed);
        return isElementDisplayed;
    }

    public static loginQuestions displayed() {
        return new loginQuestions();
    }
}
