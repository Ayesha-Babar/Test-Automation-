package Networks;

import Login.POST_ztaLogin;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class POST_createNetworkGroup_EndToEnd extends BaseTest {
    public static String id;

    @Test

    public void test() {

        POST_createNetworks st = new POST_createNetworks();
        st.test();
        String id2 = st.getId2();
        String id3 = st.getId3();
        POST_ztaLogin login = new POST_ztaLogin();
        login.zta();
        String csrf_token = login.getCsrf_token();
        String oauth_token = login.getOauthtoken2();
        String api_token = login.getApitoken2();
        String networkUrl = "https://dev.qa.xcloudiq.com/resource/api/v1/resources/network-groups/";


        Response response2 = RestAssured
                .given().contentType(ContentType.JSON)
                .header("Cookie", "api_access_token=" + api_token + "; oauth2AccessToken=" + oauth_token + ";csrftoken=" + csrf_token)
                .header("x-csrftoken", csrf_token)
                .body("{\"name\":\"network group\",\"description\":\"\",\"networks\":[\"" + id2 + "\", \"" + id3 + "\"]}")
                .baseUri(networkUrl)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        //verify if success is true
        boolean success = JsonPath.read(response2.body().asString(), "$.success");
        Assert.assertTrue(success);

        //verify the description of the response
        String description = JsonPath.read(response2.body().asString(), "$.description");
        assertEquals("Network group created successfully", description);

        id = JsonPath.read(response2.body().asString(), "$.payload.id");

        //Delete network group
        Response response = RestAssured.given()
                .header("Cookie", "api_access_token=" + api_token + "; oauth2AccessToken=" + oauth_token + ";csrftoken=" + csrf_token)
                .header("x-csrftoken", csrf_token)
                .baseUri("https://dev.qa.xcloudiq.com/resource/api/v1/resources/network-groups/")
                .when()
                .delete("/" + id + "/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();


        boolean success2 = JsonPath.read(response.body().asString(), "$.success");
        Assert.assertTrue(success2);

        String description2 = JsonPath.read(response.body().asString(), "$.description");
        assertEquals("Network group deleted successfully", description2);

        //Get network groups
        String networkgroupsUrl = "https://dev.qa.xcloudiq.com/resource/api/v1/resources/network-groups/?limit=12&offset=0";
        Response response3 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Cookie", "api_access_token=" + api_token + "; oauth2AccessToken=" + oauth_token + ";csrftoken=" + csrf_token)
                .baseUri(networkgroupsUrl)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println(response.getBody().asString());

        boolean success3 = JsonPath.read(response3.body().asString(), "$.success");
        Assert.assertTrue(success3);
        String jsonResponse = response3.getBody().asString();

        DocumentContext context = JsonPath.parse(jsonResponse);

        // Use JsonPath to extract the 'payload.networks' array
        Object networks = context.read("$.payload..network_groups");

        // Convert to a string for easier processing
        String networkList = networks.toString();

        // Assert that "network group" is present
        assertTrue("network group is present", networkList.contains("network group"));


        //Delete network 1
        Response res = RestAssured.given()
                .header("Cookie", "api_access_token=" + api_token + "; oauth2AccessToken=" + oauth_token + ";csrftoken=" + csrf_token)
                .header("x-csrftoken", csrf_token)
                .baseUri("https://dev.qa.xcloudiq.com/resource/api/v1/resources/networks")
                .when()
                .delete("/" + id2 + "/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        boolean success_3 = JsonPath.read(res.body().asString(), "$.success");
        Assert.assertTrue(success_3);

        String description3 = JsonPath.read(res.body().asString(), "$.description");
        assertEquals("Network deleted successfully.", description3);

        //Delete network 2
        Response res2 = RestAssured.given()
                .header("Cookie", "api_access_token=" + api_token + "; oauth2AccessToken=" + oauth_token + ";csrftoken=" + csrf_token)
                .header("x-csrftoken", csrf_token)
                .baseUri("https://dev.qa.xcloudiq.com/resource/api/v1/resources/networks")
                .when()
                .delete("/" + id3 + "/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        boolean success4 = JsonPath.read(res2.body().asString(), "$.success");
        Assert.assertTrue(success4);

        String description4 = JsonPath.read(res2.body().asString(), "$.description");
        assertEquals("Network deleted successfully.", description4);


    }
}



