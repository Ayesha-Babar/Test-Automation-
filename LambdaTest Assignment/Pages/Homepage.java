package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Homepage
{


   private  WebDriver driver;
 public Homepage(WebDriver driver)
 {
     System.out.println("driver = " + driver);
     this.driver=driver;
 }

    private By SimpleFormDemo_Button=By.xpath("//a[contains(text(),'Simple Form Demo')]");
    private By CheckBoxDemo_Button= By.xpath("//a[contains(text(),'Checkbox Demo')]");
    private By RadioButtonsDemo_Button=By.xpath("//a[contains(text(),'Radio Buttons Demo')]");
    private By SelectDropdownList_Button=By.xpath("//a[contains(text(),'Select Dropdown List')]");
    private By InputFormSubmit_Button= By.xpath("//a[contains(text(),'Input Form Submit')]");
    private By AjaxFormSubmit_Button=By.xpath("//a[contains(text(),'Ajax Form Submit')]");
    private By JQuerySelectDropdown_Button=By.xpath("//a[contains(text(),'JQuery Select dropdown')]");
    private By KeyPress_Button=By.xpath("//a[contains(text(),'Key Press')]");
    private By uploadFileDemo_Button=By.xpath("//a[contains(text(),'Upload File Demo')]");
    private By DownloadFileDemo_Button=By.xpath("//a[contains(text(),'Download File Demo')]");
    private By JQueryDownloadProgressBars_Button=By.xpath("//a[contains(text(),'JQuery Download Progress bars')]");
    private By BootstrapProgressBar_Button=By.xpath("//a[contains(text(),'Bootstrap Progress bar')]");
    private By DragAndDropSliders_Button=By.xpath("//a[contains(text(),'Drag & Drop Sliders')]");
    private By BootstrapsAlerts_Button=By.xpath("//a[contains(text(),'Bootstrap Alerts')]");
    private By BootstrapsModal_Button= By.xpath("//a[contains(text(),'Bootstrap Modals')]");
    private By WindowPopupModal_Button= By.xpath("//a[contains(text(),'Window Popup Modal')]");
    private By ProgressBarModal_Button=By.xpath("//a[contains(text(),'Progress Bar Modal')]");
    private By JavaScriptAlerts_Button= By.xpath("//a[contains(text(),'Javascript Alerts')]");
    private By FileDownload_Button=By.xpath("//a[contains(text(),'File Download')]");

    private By Sliderdemo_Button= By.linkText("Drag & Drop Sliders");

    public void clickButton(By button)
    {
        driver.findElement(button).click();

    }

    public SimpleFormDemoPage clickSimpleFormDemo()
    {
       clickButton(SimpleFormDemo_Button);
         return new SimpleFormDemoPage(driver);

       // driver.findElement(By.xpath(SimpleFormDemo_Button).click();
       // return new SimpleFormDemoPage(driver);
    }
    public CheckboxDemoPage clickcheckboxdemopage()
    {
        clickButton(CheckBoxDemo_Button);
        return new CheckboxDemoPage(driver);
    }

    public InputFormSubmitPage clickInputFormSubmit()
    {
        clickButton(InputFormSubmit_Button);
        return new InputFormSubmitPage(driver);

    }

    public SliderDemoPage clickDragandDrop()
    {
        clickButton(Sliderdemo_Button);
        return new SliderDemoPage(driver);
    }





}
