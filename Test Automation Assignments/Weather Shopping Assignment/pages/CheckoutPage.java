package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class CheckoutPage
{
    WebDriver driver;
    private By TotalCost= By.xpath("//p[@id='total']");
    private By PaywithCard_button = By.xpath("//button[@type='submit']");
    private By emailField= By.xpath("//input[@id='email']");
    private By cardNumberField= By.xpath("//input[@id='card_number']");
    private By dateField= By.xpath("//input[@id='cc-exp']");
    private By cvcField= By.xpath("//input[@id='cc-csc']");
    private By PayButton =By.xpath("//button[@id='submitButton']//span//span");
    private By Zipcode= By.xpath("//input[@id='billing-zip']");
    public CheckoutPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public int parsePrice(String priceText)
    {
        String numericpart= priceText.replaceAll("[^0-9]", "");
        int extractedPrice= Integer.parseInt(numericpart);

        return extractedPrice;
    }

    public int checkTotalPrice()
    {
        String price = driver.findElement(TotalCost).getText();
        int p= parsePrice(price);
        return p;
    }

    public PaymentSuccessPage clickPaywithcard()
    {
      driver.findElement(PaywithCard_button).click();
      driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
      driver.switchTo().frame("stripe_checkout_app");
      WebElement email =driver.findElement(emailField);
      sendKeysJS(email,"ayeshababar183@gmail.com");
      WebElement card=driver.findElement(cardNumberField);
      sendKeysJS(card,"4242 4242 4242 4242");
     WebElement date= driver.findElement(dateField);
     sendKeysJS(date,"03/28");
      WebElement cvc=driver.findElement(cvcField);
      sendKeysJS(cvc,"655");
      WebElement zip= driver.findElement(Zipcode);
      sendKeysJS(zip,"44000");
      WebElement button =driver.findElement(PayButton);
      button.click();
      return new PaymentSuccessPage(driver);
    }

    private void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value = arguments[1];", element, text);
    }

    private void ClickButtonJS(WebElement buttonElement)
    {
        JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", buttonElement);
    }

}