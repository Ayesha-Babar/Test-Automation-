package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HoverDemoPage
{
    private WebDriver driver;
    //CSS HOVER EFFECTS ON BUTTONS
    private By GreenHoverMe_Button=By.cssSelector("div[class*=\"bg-green-100\"]");
    private By BlueHoverMe_Button= By.cssSelector("div[class*=\"bg-green-200\"]");

    private By LinkHover= By.xpath("//div[contains(text(),'Link Hover')]");
    private By HoverMe=By.xpath("//div[contains(@class,'ml-40 font-semibold')]");

    // CSS EFFECTS ON IMAGES
    private By NoEffectOnlyContentShow_Image= By.xpath("//div[@class='s__column m-15']//img");
    private By HoverMessage=By.xpath("//p[text()='Hover']");
    private By ZoomIn_Image=By.xpath("//div[@class='s__column2']//img");
    private By ZoomOut_Image=By.xpath("//div[@class='s__column3']//img");
    private By ZoomOutSlide_Image=By.xpath("//div[@class='ml-15 mt-15 h-190']//img");
    private By RotateAndZoomOut_Image=By.xpath("//div[@class='hover06 s__column']//img");
    private By Blur_Image=By.xpath("//div[@class='hover07 s__column']//img");
    private By GrayScale_Image=By.xpath("//div[@class='hover08 s__column']//img");
    private By BlurAndGrayScale_Image=By.xpath("//div[@class='hover09 s__column']//img");
    private By Opacity_Image=By.xpath("//div[@class='hover10 s__column']//img");
    private By Flashing_Image=By.xpath("//div[@class='hover11 s__column']//img");


    public HoverDemoPage(WebDriver driver)
    {
        this.driver= driver;
    }


    public Boolean HoverOverHoverMeGreenButton()
    {
        // this function would return true on change of background color and text color on hovering over green hover me button
        WebElement GreenHoverMe= driver.findElement(GreenHoverMe_Button);

        // extract the initial background color and initial text color
        String initialBackgroundColor= GreenHoverMe.getCssValue("background-color");
        String initialTextColor=GreenHoverMe.getCssValue("color");

        Actions actions= new Actions(driver);
        actions.moveToElement(GreenHoverMe).perform();

        // extract the color of the element after hovering over it
        // the background color of this button changes from green to white on hovering over it
        // and the text color changes from white to green
        String hoveredTextColor= GreenHoverMe.getCssValue("color");
        String hoveredBackgroundColor=GreenHoverMe.getCssValue("background-color");


        if(initialTextColor!=hoveredTextColor && initialBackgroundColor!=hoveredBackgroundColor)
        {
            return true;
        }
        return false;

    }

    public boolean HoverBlueHoverMeButton()
    {
        // this function would return true on change of background color and text color on hovering over blue hover me button
        WebElement BlueHoverMe= driver.findElement(BlueHoverMe_Button);

        // extract the initial background color
        String initialBackgroundColor= BlueHoverMe.getCssValue("background-color");


        Actions actions= new Actions(driver);
        actions.moveToElement(BlueHoverMe).perform();

        // extract the color of the element after hovering over it
        // the background color of this button changes from blue to dark on hovering over it

        String hoveredBackgroundColor= BlueHoverMe.getCssValue("background-color");


        if( initialBackgroundColor!=hoveredBackgroundColor)
        {
            return true;
        }
        return false;

    }

    public boolean HoverLinkHover()
    {
        WebElement linkhover= driver.findElement(LinkHover);

        // Before and after the hover action, we retrieve the CSS value of the text-decoration property using getCssValue.
        // This property should change when the line appears under the text.
        String initialTextDecoration = linkhover.getCssValue("text-decoration");

        // perform hover action
        Actions actions= new Actions(driver);
        actions.moveToElement(linkhover).perform();

        String hoveredTestDecoration= linkhover.getCssValue("text_decoration");

        // check if line appears under text; text decoration would change
        if(initialTextDecoration!=hoveredTestDecoration)
        {
            return true;
        }
        return false;


    }

    public boolean HoverOverLastHoverMeButton()
    {
        WebElement hoverme= driver.findElement(HoverMe);
        String initialTextColor=hoverme.getCssValue("color");

        Actions actions= new Actions(driver);
        actions.moveToElement(hoverme).perform();

        String BackgroundTextColor=hoverme.getCssValue("color");

        if(initialTextColor!=BackgroundTextColor)
        {
            return true;
        }
        return false;

    }

    //for images
    public boolean NoEffectOnlyContentShow()
    {
        WebElement image= driver.findElement(NoEffectOnlyContentShow_Image);

        Actions actions= new Actions(driver);
        actions.moveToElement(image).perform();

        // check if hovering over this image displays Hover message
        return driver.findElement(HoverMessage).isDisplayed();

    }
    public int Zoom(By Object)
    {
        WebElement image= driver.findElement(Object);

        Actions actions= new Actions(driver);
        actions.moveToElement(image).perform();

        String transformValue=image.getCssValue("transform");
        String transform = image.getCssValue("transform");
        double scaleFactor = getScaleFactor(transform);
        if (scaleFactor > 1) {
            System.out.println("Image is zoomed in.");
        }
        return (int) scaleFactor;


    }
    private double getScaleFactor(String transformValue) {
        double scale = 1.0; // Default scale factor if not found
        if (transformValue != null && transformValue.contains("scale")) {
            String[] parts = transformValue.split("scale\\(");
            if (parts.length > 1) {
                String scalePart = parts[1].split("\\)")[0];
                try {
                    scale = Double.parseDouble(scalePart);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return scale;
    }
}









