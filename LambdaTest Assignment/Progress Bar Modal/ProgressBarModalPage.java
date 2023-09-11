package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgressBarModalPage
{
    WebDriver driver;
    private By ShowDialogTwoSeconds=By.xpath("//button[contains(text(),'Autoclose after 2 seconds')]");
    private By ModalTwoSeconds= By.xpath("//h3[contains(text(),'Loading')]");
    private By WaitingDialog= By.xpath("//h2[contains(text(),'Hello Alert')]");
    private By ShowDialogThreeSeconds=By.xpath("//button[contains(text(),'3 seconds')]");
    private By ModalThreeSeconds=By.xpath("////div[@class='modal fade']//h3[text()='Custom message']");
    private By ShowDialogFiveSeconds= By.xpath("//button[contains(text(),'5 seconds')]");
    private By ModalFiveSeconds= By.xpath("//h3[contains(text(),'Hello Mr. Alert')]");

    public ProgressBarModalPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickShowDialogForTwoSec()
    {
        driver.findElement(ShowDialogTwoSeconds).click();

    }
    public boolean ModalDisplayTwoSeconds()
    {
        return driver.findElement(ModalTwoSeconds).isDisplayed();
    }

    public String WaitingDialogHelloAlert()
    {
        return driver.findElement(WaitingDialog).getText();
    }

    public void clickShowDialogThreeseconds()
    {
        driver.findElement(ShowDialogThreeSeconds).click();
    }

    public boolean ModalDisplayThreeSeconds()
    {
       return driver.findElement(ModalThreeSeconds).isDisplayed();
    }

    public String GetModalTextThreeSeconds()
    {
        return driver.findElement(ModalThreeSeconds).getText();
    }

    public void clickShowDialogFiveSeconds()
    {
        driver.findElement(ShowDialogFiveSeconds).click();
    }

    public boolean ModalDisplayFiveSeconds()
    {
        return driver.findElement(ModalFiveSeconds).isDisplayed();
    }

    public String GetModalTextFiveSeconds()
    {
       return driver.findElement(ModalFiveSeconds).getText();
    }

}

