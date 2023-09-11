

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider
{
    @Test(dataProvider = "login-provider")
    public void login(String email, String password, boolean success) {
        System.out.println("Log in credentials: "+ "/n"+
                "email= "+email+"/n"+
                "successful log in= "+success+"/n");
    }

    @DataProvider(name ="login-provider")
    public Object[][] loginData() {
        Object[][] data = new Object[3][3];

        data[0][0] = "testing frame";
        data[0][1] = "testng1234";
        data[0][2] = true;
        data[1][0] = "joe";
        data[1][1] = "doe234";
        data[1][3] = false;
        data[2][0] = "test automation";
        data[2][1] = "tau123";
        data[2][2] = true;

        return data;
    }
}
