package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SliderDemoPage
{
    private WebDriver driver;
    private By slider= By.xpath("//input[@type='range']");
    private By output_5=By.id("range");
    private By output_20=By.id("rangePrimary");
    private By output_15= By.id("rangeSuccess");
    private By output_50= By.id("rangeInfo");
    private By output_25=By.id("rangeWarning");
    private By output_30=By.xpath("//output[contains(text(),30)]");
    private By output_40=By.id("rangeWarning");
    private By output_80= By.xpath("//output[contains(text(),80)]");
    List<WebElement>sliderlist= (List<WebElement>)driver.findElements(slider);


    public SliderDemoPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public int printSliderListSize()
    {
        return sliderlist.size();
    }

    /**
     *
     * @param index refers to the nth slider; there are a total of 8 sliders
     * @param number refers to the number that the slider is set to
     */
    public void SetSlidervalue(int index, int number)
    {
        if (index >= 1 && index <= sliderlist.size()) {
            WebElement sliderToSet = sliderlist.get(index - 1);
            sliderToSet.click();
            for(int i=0;i<number-1;i++)
            {
                sliderToSet.sendKeys(Keys.ARROW_RIGHT);
            }

        } else {
            throw new IllegalArgumentException("Invalid index for slider");
        }


    }

    public String GetSliderValue(int index) {
        List<WebElement> sliderList = driver.findElements(slider);

        if (index >= 1 && index <= sliderList.size()) {
            WebElement sliderToGet = sliderList.get(index - 1);

            // Get the value attribute of the slider
            return sliderToGet.getAttribute("value");
        } else {
            throw new IllegalArgumentException("Invalid index for slider");
        }
    }



}
