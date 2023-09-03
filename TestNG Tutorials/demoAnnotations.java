package TestNg;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class demoAnnotations {
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

    SoftAssert softassert = new SoftAssert();

    @Test
    public void testHomePageVerification() {
        //hard asserts : if one fails, compiler moves to the next annotation without executing the subsequent assertions.
        softassert.assertEquals(true, true, "the welcome link isnt correct on the home page");
        System.out.println("verify welcome link");

        softassert.assertFalse(false, "the admin tab isnt displayed on the homepage");
        System.out.println("verify the admin tab");

        softassert.assertTrue(true, "the dashboard isnt correct on the homepage");
        System.out.println("verify dashboard");

        softassert.assertAll();
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
