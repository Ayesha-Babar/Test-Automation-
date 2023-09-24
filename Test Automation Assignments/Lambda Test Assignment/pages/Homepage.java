package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Homepage
{


   private  WebDriver driver;
 public Homepage(WebDriver driver)
 {
     System.out.println("driver = " + driver);
     this.driver=driver;
 }

    public void clicklink(String link)
    {
        driver.findElement(By.linkText(link)).click();
    }


    public SimpleFormDemoPage clickSimpleFormDemo()
    {
       clicklink("Simple Form Demo");
         return new SimpleFormDemoPage(driver);
    }
    public CheckboxDemoPage clickcheckboxdemopage()
    {
        clicklink("Checkbox Demo");
        return new CheckboxDemoPage(driver);
    }

    public InputFormSubmitPage clickInputFormSubmit()
    {
        clicklink("Input Form Submit");
        return new InputFormSubmitPage(driver);

    }

    public DragAndDropSlidersPage clickDragandDrop()
    {
        clicklink("Drag & Drop Sliders");
        return new DragAndDropSlidersPage(driver);
    }

    public DropdownDemoPage clickdropdowndemo()
    {
        clicklink("Select Dropdown List");
        return new DropdownDemoPage(driver);
    }

    public HoverDemoPage clickHoverdemo()
    {
        clicklink("Hover Demo");
        return new HoverDemoPage(driver);
    }

    public JavascriptAlerts clickJavaScriptAlerts()
    {
        clicklink("Javascript Alerts");
        return new JavascriptAlerts(driver);
    }

    public KeyPressPage clickKeyPress()
    {
        clicklink("Key Press");
        return new KeyPressPage(driver);
    }

    public FileUploadPage clickUploadFileDemo()
    {
        clicklink("Upload File Demo");
        return new FileUploadPage(driver);
    }

    public DownloadFilePage clickDownloadFile()
    {
        clicklink("Download File Demo");
        return  new DownloadFilePage(driver);
    }

    public AjaxFormSubmitPage clickAjaxFormSubmit()
    {
        clicklink("Ajax Form Submit");
        return new AjaxFormSubmitPage(driver);
    }

    public JQueryDownloadProgressBarPage clickJqueryBar()
    {
        clicklink("JQuery Download Progress bars");
         return new JQueryDownloadProgressBarPage(driver);
    }

    public BootstrapAlertMessagePage clickBootstrapAlert()
    {
        clicklink("Bootstrap Alerts");
        return new BootstrapAlertMessagePage(driver);
    }

    public BootstrapDownloadProgressBarPage clickBootstrapProgressBar()
    {
        clicklink("Bootstrap Progress bar");
        return new BootstrapDownloadProgressBarPage(driver);
    }

    public FileDownloadPage clickFileDownload()
    {
        clicklink("File Download");
        return new FileDownloadPage(driver);
    }

    public ProgressBarModalPage clickProgressBarModal()
    {
        clicklink("Progress Bar Modal");
        return new ProgressBarModalPage(driver);
    }

    public JQueryDatePickerPage clickJQueryDatePicker()
    {
        clicklink("JQuery Date Picker");
        return new JQueryDatePickerPage(driver);
    }

    public TablePaginationPage clicktablePagination()
    {
        clicklink("Table Pagination");
        return new TablePaginationPage(driver);
    }

    public RedirectionPage clickRedirection()
    {
        clicklink("Redirection");
        return new RedirectionPage(driver);
    }

    public BootstrapListPage clickBootstrapList()
    {
        clicklink("Bootstrap List Box");
        return  new BootstrapListPage(driver);
    }

    public JQueryListBoxPage clickJQueryListBox()
    {
        clicklink("JQuery List Box");
        return new JQueryListBoxPage(driver);

    }

    public ContextMenuPage clickcontextMenu()
    {
        clicklink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public DragAndDropPage clickDragAndDrop()
    {
        clicklink("Drag and Drop");
        return new DragAndDropPage(driver);
    }

    public TableSortAndSearch clickTableSearch()
    {
        clicklink("Table Sort & Search");
        return new TableSortAndSearch(driver);
    }

    public BootstrapModalPage clickBootstrapModal()
    {
        clicklink("Bootstrap Modals");
        return new BootstrapModalPage(driver);
    }

    public WindowPopupModalPage clickWindowPopup()
    {
        clicklink("Window Popup Modal");
        return new WindowPopupModalPage(driver);
    }

    public TablefilterPage clickTableFilter()
    {
        clicklink("Table Filter");
        return new TablefilterPage(driver);
    }

    public TableDataSearchPage clickTableDataSearch()
    {
        clicklink("Table Data Search");
        return new TableDataSearchPage(driver);
    }

    public DynamicDataLoadingPage clickDynamicDataLoading()
    {
        clicklink("Dynamic Data Loading");
        return new DynamicDataLoadingPage(driver);
    }

    public VirtualDOM clickVirtualDom()
    {
        clicklink("Virtual DOM");
        return new VirtualDOM(driver);
    }

    public ShadowDOM clickShadowDom()
    {
        clicklink("Shadow DOM");
        return new ShadowDOM(driver);
    }

    public GeolocationTestingPage clickGeolocation()
    {
        clicklink("Geolocation Testing");
        return new GeolocationTestingPage(driver);
    }

    public JQuerySelectDropdownPage clickJQueryDropdown()
    {
        clicklink("JQuery Select dropdown");
        return new JQuerySelectDropdownPage(driver);
    }

    public RadioButtonDemoPage clickRadioButton()
    {
        clicklink("Radio Buttons Demo");
        return new RadioButtonDemoPage(driver);
    }

    public BootstrapDatePickerPage clickBootstrapDatePicker()
    {
        clicklink("Bootstrap Date Picker");
        return new BootstrapDatePickerPage(driver);
    }

    public DataListFilterPage clickdataList()
    {
        clicklink("Data List Filter");
        return new DataListFilterPage(driver);
    }




}
