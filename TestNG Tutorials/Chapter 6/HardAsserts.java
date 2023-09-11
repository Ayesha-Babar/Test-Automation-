import org.testng.Assert;
import org.testng.annotations.*;

public class HardAsserts {
    //arranged in execution order
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Chrome- system set up property");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("open chrome");
    }

    @BeforeClass
    public void beforeclass() {
        System.out.println("open test application");
    }

    @BeforeMethod
    public void signIn() {
        System.out.println("before test method" + " sign in");
    }


    @Test(priority = 1)
    public void publicSearchCustomer() {
        System.out.println("Search for customer");
    }

    @Test //(dependsOnMethods = {"publicSearchCustomer","signIn" })
    public void publicSearchProduct() {
        System.out.println("Search for product  ");
    }

    // HARD ASSERTS
    @Test
    public void HardAsserts()
    {
        Assert.assertEquals(true,true,"both are equal");
        Assert.assertFalse(false,"this is false");

    }






    @AfterMethod
    public void afterMethod() {
        System.out.println("sign out");
    }

    @AfterClass
    public void afterclass() {
        System.out.println("close test application");

    }

    @AfterTest
    public void afterTest() {
        System.out.println("close chrome");
    }


    @AfterSuite
    public void afterSuite() {
        System.out.println("clean up all cookies");
    }

}

