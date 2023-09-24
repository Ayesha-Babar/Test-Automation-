package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class InputFormSubmitPage
{
   static WebDriver driver;
   public InputFormSubmitPage(WebDriver driver)
   {
       this.driver=driver;

   }
   private By namefield= By.xpath("//input[@id='name']");
   private By emailfield= By.xpath("//input[@id='inputEmail4']");
   private By Passwordfield=By.xpath("//input[@id='inputPassword4']");
   private By Companyfield=By.xpath("//input[@id='company']");
   private By websitefield=By.xpath("//input[@id='websitename']");
   private By Cityfield=By.xpath("//input[@id='inputCity']");
   private By Addressfield1=By.xpath("//input[@id='inputAddress1']");
   private By Addressfield2=By.xpath("//input[@id='inputAddress2']");
   private By Statefield=By.xpath("//input[@id='inputState']");
   private By ZipCodefield=By.xpath("//input[@id='inputZip']");
   private By DropdownCountry=By.xpath("//select[@name='country']");
   private By submitButton=By.xpath("//button[@type='submit' and text()='Submit']");




   public void Fillfields(String name,String email, String password,String company, String website,String city,String address1,String address2,String state,String code)
   {
       driver.findElement(namefield).sendKeys(name);
       driver.findElement(emailfield).sendKeys(email);
       driver.findElement(Passwordfield).sendKeys(password);
       driver.findElement(Companyfield).sendKeys(company);
       driver.findElement(websitefield).sendKeys(website);
       driver.findElement(Cityfield).sendKeys(city);
       driver.findElement(Addressfield1).sendKeys(address1);
       driver.findElement(Addressfield2).sendKeys(address2);
       driver.findElement(Statefield).sendKeys(state);
       driver.findElement(ZipCodefield).sendKeys(code);
   }

    public Select finddropdown()
    {
        return new Select(driver.findElement(DropdownCountry));
    }



    public void selectFromDropdown(String countryName) {
        WebElement dropdownElement = driver.findElement(DropdownCountry);

        // Click the dropdown to open it (if clicking is necessary)
        dropdownElement.click();

        // Use the Select class to select an option by visible text
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(countryName);
    }

    public List<String> getselectedOption()
    {
        List<WebElement>selectedOptions=finddropdown().getAllSelectedOptions();
        return selectedOptions.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public InputFormValidationPage ClickSubmitButton()
    {
        driver.findElement(submitButton).click();
        return new InputFormValidationPage(driver);
    }

    public class InputFormValidationPage
    {
        WebDriver driver;
        private By InputFormValidationsHeader=By.xpath("//h2[contains(text(),'Input form validations')]");
        private By InputformvalidationsMessage=By.xpath("//p[contains(text(),'Thanks for contacting us')]");

        public InputFormValidationPage(WebDriver driver)
        {
            this.driver=driver;
        }

        public boolean headerDisplay()
        {
              return driver.findElement(InputFormValidationsHeader).isDisplayed();
        }

        public boolean messagedDisplay()
        {
            return driver.findElement(InputformvalidationsMessage).isDisplayed();
        }
    }






}
