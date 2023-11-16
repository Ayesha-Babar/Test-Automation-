package Users;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class userQuestions {


    public static Question<Boolean> inList(String searchString,List<WebElement>USER_LIST) {
       return actor ->
       {
         if(USER_LIST.contains(searchString)) {
             return true;
         }
         else
             return false;
       };
       }

    }

