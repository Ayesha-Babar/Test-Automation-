package Login;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.FileNameConstants;

import java.io.File;
import java.io.IOException;

public class POST_xiqLogin extends BaseTest {
    static Cookie oauthcookie;
    static Cookie apitoken;
    @Test
    public void logintest()
    {
        try {
            String postApirequestBody = FileUtils.readFileToString(new File(FileNameConstants.POST_API_REQUEST_BODY));
            Response response = RestAssured
                    .given()
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .formParam("username", "azfar.altaf@emumba.com")
                    .formParam("password", "Emumba@123")
                    .baseUri("https://dis1.qa.xcloudiq.com/oauth/login")
                    .when()
                    .post()// Adjust the endpoint path as needed
                    .then()
                    .assertThat()
                    .statusCode(302)
                    .extract()
                    .response();


            oauthcookie = response.getDetailedCookie("oauth2AccessToken");
            apitoken = response.getDetailedCookie("api_access_token");

            System.out.println(oauthcookie);
            System.out.println(apitoken);




        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static Cookie getOauthcookie() {
        return oauthcookie;
    }

    public static void setOauthcookie(Cookie oauthcookie1)
    {
        POST_xiqLogin.oauthcookie=oauthcookie1;
    }

    public static Cookie getApitoken() {
        return apitoken;
    }

    public static void setApitoken(Cookie apitoken) {
        POST_xiqLogin.apitoken = apitoken;
    }
}