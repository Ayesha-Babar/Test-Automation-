package users;

import Login.POST_ztaLogin;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class GET_checkuserGroups
{
    @Test
    public void test()
    {
        String UserGroupURL="https://dev.qa.xcloudiq.com/resource/api/v1/access-group/?limit=12&offset=0";
        POST_ztaLogin login= new POST_ztaLogin();
        login.zta();
        String csrf_token= login.getCsrf_token();
        String oauth_token= login.getOauthtoken2();
        String api_token= login.getApitoken2();
        Response response= RestAssured.given()
                .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                .header("x-csrftoken",csrf_token)
                .baseUri(UserGroupURL)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println(response.getBody().asString());
        var jsonPath=response.jsonPath();

       List<String> usergroups= jsonPath.getList("payload.access_groups.name");

        boolean usergroupExists= usergroups.contains("demo");
        assertTrue(usergroupExists);

        int numberOfuserGroups= usergroups.size();
        System.out.println("The number of user groups are "+numberOfuserGroups);
    }
}
