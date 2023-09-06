package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage {
    private WebDriver driver;
    private By figurebox= By.className("figcaption");
    public HoverPage(WebDriver driver)
    {
        this.driver=driver;

    }

    public FigureCaption hoveroverFigure(int index)
    {
        WebElement figure= driver.findElements(figurebox).get(index-1);
        Actions action= new Actions(driver);
        action.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(figurebox));


    }

    public class FigureCaption
    {
        private WebElement caption;
        private By header= By.tagName("h5");
        private By link= By.tagName("a");

        public FigureCaption(WebElement caption)
        {
            this.caption= caption;
        }

        public boolean isCaptionDisplayed()
        {
            return caption.isDisplayed();
        }

        public String GetTitle()
        {
            return caption.findElement(header).getText();
        }

        public String getLink()
        {
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText()
        {
           return caption.findElement(link).getText();
        }
    }


}
