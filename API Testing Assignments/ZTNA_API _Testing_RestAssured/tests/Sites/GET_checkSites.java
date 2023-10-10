package Sites;

import Login.POST_ztaLogin;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class GET_checkSites
{
    @Test
    public void test()
    {
        POST_ztaLogin login= new POST_ztaLogin();
        login.zta();
        String csrf_token= login.getCsrf_token();
        String oauth_token= login.getOauthtoken2();
        String api_token= login.getApitoken2();

        String GetsiteURL="https://dev.qa.xcloudiq.com/resource/api/v1/resources/sites/?limit=12&offset=0";
        Response response= RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                .baseUri(GetsiteURL)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println(response.getBody().asString());
        var jsonPath=response.jsonPath();

        List<String>sitenames= jsonPath.getList("payload.sites.name");

        boolean sitetestExists= sitenames.contains("sitetest");
        assertTrue(sitetestExists);

        int numberOfsites= sitenames.size();
        System.out.println(numberOfsites);
    }
}
