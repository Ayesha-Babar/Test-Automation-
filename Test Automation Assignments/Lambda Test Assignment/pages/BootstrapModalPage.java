package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BootstrapModalPage {
    WebDriver driver;

    private By LaunchModalButtons = By.xpath("//button[contains(text(),'Launch Modal')]");
    private By ModalButton = By.xpath("//button[@data-target='#myModal']");
    private By save_button = By.xpath("//button[text()='Save Changes']");

    public BootstrapModalPage(WebDriver driver) {

        this.driver = driver;
    }


    public void clickLaunchModal(int index) {
        List<WebElement> buttons = driver.findElements(LaunchModalButtons);
        buttons.get(index).click();
    }

    public String GetcontentModal() {

        int timeoutInSeconds = 10;
        Duration timeoutDuration = Duration.ofSeconds(timeoutInSeconds);

        WebElement modalContainer = new WebDriverWait(driver, timeoutDuration)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));
        WebElement modalContentBody = modalContainer.findElement(By.xpath(".//div[@class='modal-body']"));
        String text = modalContentBody.getText();

        return text;
    }


    public void clickSave(int index) {
        List<WebElement> save = driver.findElements(save_button);
        save.get(index).click();
    }


    public String GetContentMultipleModal() {
        int timeoutInSeconds = 10;
        Duration timeoutDuration = Duration.ofSeconds(timeoutInSeconds);

        WebElement modalContainer = new WebDriverWait(driver, timeoutDuration)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myMultiModal']")));

        WebElement modalContentBody = modalContainer.findElement(By.xpath(".//div[@class='modal-body']"));
        String text = modalContentBody.getText();
        return text;

    }


    public String GetContentSecondMultiModal()
    {
        int timeoutInSeconds = 10;
        Duration timeoutDuration = Duration.ofSeconds(timeoutInSeconds);

        WebElement modalContainer = new WebDriverWait(driver, timeoutDuration)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mySecondModal']")));

        WebElement modalContentBody = modalContainer.findElement(By.xpath(".//div[@class='modal-body']"));
        String text = modalContentBody.getText();
        return text;
    }
}

