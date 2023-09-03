import org.testng.annotations.Test;

public class dependsOnMethod
{
    public void test_Setup()
    {
        System.out.println("Set up chrome");
    }

    public void test2_openApplication()
    {
        System.out.println("open application");
    }

    @Test(dependsOnMethods = {"test2_openApplication","test_Setup"})
    public void test3_signin()
    {
        System.out.println("sign in");
    }

    @Test(dependsOnMethods="test3_signin")
    public void searchCustomer()
    {
        System.out.println("search customer");
    }

    @Test(dependsOnMethods={"test_openApplication","test3_signin"})
    public void signout()
    {
        System.out.println("sign out ");
    }


}
