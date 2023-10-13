import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class Steps extends BaseUtil
{
    private WebDriver driver;
    private BaseUtil baseutil;

    public Steps(BaseUtil util)
    {
       this.baseutil=util;
    }
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emumba\\cucumber\\src\\main\\resources\\new chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am in the login page")
    @Given("I am in the login page of para bank application")
    public void i_am_in_the_login_page_of_para_bank_application() {

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid {string} and {string} with {string}")
    public void i_enter_valid_credentials(String username,String password,String userFullName1) {
        // Implement your code to enter the username and password
        //List<String> loginform=table.asList();
        baseutil.userFullName=userFullName1;
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
    }

    @Then("I should be taken to the overview page")
    public void i_should_be_taken_to_the_overview_page() throws InterruptedException {
        // Implement your code to verify that you are on the overview page
        Thread.sleep(5000);
        String actualuserFullName= driver.findElement(By.className("smallText")).getText().toString();
        System.out.println(baseutil.userFullName.toString());
        assertTrue(actualuserFullName,actualuserFullName.contains(baseutil.userFullName));
        driver.findElement(By.linkText("Log Out")).click();

        driver.findElement(By.id("rightPanel")).isDisplayed();
        driver.findElement(By.linkText("Log out")).click();
    }

    @After
    public void teardown()
    {
        driver.quit();
    }

    @When("I enter valid <username> and <password> with <userFullName>")
    public void iEnterValidUsernameAndPasswordWithUserFullName() {
    }
}


