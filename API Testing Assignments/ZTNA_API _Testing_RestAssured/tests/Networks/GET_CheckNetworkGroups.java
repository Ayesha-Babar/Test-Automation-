package Networks;

import Login.POST_ztaLogin;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class GET_CheckNetworkGroups
{
    @Test
    public void test() {
        POST_ztaLogin login= new POST_ztaLogin();
        login.zta();
        String csrf_token= login.getCsrf_token();
        String oauth_token= login.getOauthtoken2();
        String api_token= login.getApitoken2();
        String networkgroupsUrl="https://dev.qa.xcloudiq.com/resource/api/v1/resources/network-groups/?limit=12&offset=0";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                .baseUri(networkgroupsUrl)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println(response.getBody().asString());

        boolean success = JsonPath.read(response.body().asString(), "$.success");
        Assert.assertTrue(success);
        String jsonResponse = response.getBody().asString();

        DocumentContext context = JsonPath.parse(jsonResponse);

        // Use JsonPath to extract the 'payload.networks' array
        Object networks = context.read("$.payload..network_groups");

        // Convert to a string for easier processing
        String networkList = networks.toString();

        // Assert that "network group" is present
        assertTrue("network group is present", networkList.contains("network group"));

    }
}
