import org.testng.annotations.Test;

public class dependsOnGroup
{
    public void test_Setup()
    {
        System.out.println("Set up chrome");
    }

    @Test(dependsOnGroups = "initialize")
    public void test2_openApplication()
    {
        System.out.println("open application");
    }

    @Test(dependsOnGroups="initialize",groups="env application")
    public void test3_signin()
    {
        System.out.println("sign in");
    }

    @Test(dependsOnGroups = "env application")
    public void searchCustomer()
    {
        System.out.println("search customer");
    }

    @Test
    public void signout()
    {
        System.out.println("sign out ");
    }


}

