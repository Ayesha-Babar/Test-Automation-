package Usergroups;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class userGroupQuestions
{
    public static boolean checkTextInWebElements(List<WebElement> elements, String textToMatch) {
        for (WebElement element : elements) {
            String elementText = element.getText();

            // Check if the text of the element matches the specified text
            if (elementText.equals(textToMatch)) {
                return true;
            }
        }
        return false;
    }
}


