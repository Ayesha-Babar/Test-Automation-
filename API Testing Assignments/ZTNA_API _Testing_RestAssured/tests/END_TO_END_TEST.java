import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FileNameConstants;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class END_TO_END_TEST
{
    public static String csrf_token;
    public static String api_token;
    public static String oauth_token;
    public static String ztnaLoginLink="https://ztna1.qa.xcloudiq.com/oauth/login";
    public static String homeredirectionLink="https://ztna1.qa.xcloudiq.com/services/acct/entry/home";
    public static String ztaredirectionLink="https://dev.qa.xcloudiq.com/auth/api/v1/accounts/login/";

    public static String id2;
    public static String id3;

    @Test
    public void EndtoEndTest()
    {
    try {

// --------------------LOGIN-------------------------------------------------
    String Body = FileUtils.readFileToString(new File(FileNameConstants.body));

    Response response1 = RestAssured
            .given()
            .header("Content-Type", "application/x-www-form-urlencoded")
            .formParam("username", "azfar.altaf@emumba.com")
            .formParam("password", "Emumba@123")
            .baseUri(ztnaLoginLink)
            .when()
            .post()
            .then()
            .assertThat()
            .statusCode(302)
            .extract()
            .response();

    String oauthcookie = response1.getCookie("oauth2AccessToken");
    String apitoken = response1.getCookie("api_access_token");
    System.out.println("The oauth token generated in xiq login is :"+oauthcookie);
    System.out.println("The api access token generated in xiq login is :"+apitoken);

    Response response2 = RestAssured.given().header("cookie", "api_access_token=" + apitoken, ",oauth2AccessToken=" + oauthcookie)
            .baseUri(homeredirectionLink)
            .when()
            .get()
            .then()
            .assertThat()
            .statusCode(200)
            .extract().response();

    System.out.println("The session ID is :"+response2.getDetailedCookies());
    oauth_token = response2.getCookie("oauth2AccessToken");
    api_token = response2.getCookie("api_access_token");
    System.out.println("The oauth token generated in home redirection login is :"+oauth_token);
    System.out.println("The api access token generated in home redirection login is :"+api_token);

    Response response3 =
            RestAssured
                    .given()
                    .header("Content-Type", "application/JSON")
                    .header("Cookie", "api_access_token=" + api_token+ "; oauth2AccessToken=" + oauth_token)
                    .header("x-oauthToken",oauth_token)
                    .baseUri(ztaredirectionLink)
                    .body(Body)
                    .when()
                    .post()
                    .then()
                    .assertThat()
                    .log().ifValidationFails()
                    .statusCode(200)
                    .extract()
                    .response();

    //Verifies if the success is true
    boolean success3= JsonPath.read(response3.body().asString(),"$.success");
    Assert.assertTrue(success3);

    //verify the description of response
    String description3= JsonPath.read(response3.body().asString(),"$.description");
    assertEquals("Logged in successfully.",description3);



    csrf_token= response3.getCookie("csrftoken");
    System.out.println("The CSRF token generated by this post request is "+csrf_token);

// --------------------SITES-------------------------------------------------
   String sitesUrl="https://dev.qa.xcloudiq.com/resource/api/v1/resources/sites/";
        String createsiteBody= FileUtils.readFileToString(new File(FileNameConstants.CREATE_SITE_BODY));
        Response response4= RestAssured
                .given().contentType(ContentType.JSON)
                .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                .header("x-csrftoken",csrf_token)
                .body(createsiteBody)
                .baseUri(sitesUrl)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(201)
                .extract().response();

        JSONArray id1= JsonPath.read(response4.body().asString(),"$.payload..id");
        String token= (String) id1.get(0);



        System.out.println(token);

        //PATCH REQUEST
        String patchbody= FileUtils.readFileToString(new File(FileNameConstants.PATCH_CREATE_SITE_BODY));


        Response response5=
                RestAssured.given()
                        .contentType(ContentType.JSON)
                        .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                        .header("x-csrftoken",csrf_token)
                        .body(patchbody)
                        .baseUri(sitesUrl)
                        .when()
                        .patch("/"+token+"/")
                        .then()
                        .assertThat()
                        .statusCode(200).extract().response();
        JSONArray ID= JsonPath.read(response5.body().asString(),"$.payload..id");
        String ID2= (String) ID.get(0);


        //DELETE REQUEST
        Thread.sleep(2000);

        Response response6 = RestAssured.given()
                .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                .header("x-csrftoken",csrf_token)
                .baseUri(sitesUrl)
                .when()
                .delete("/"+ID2+"/hard-deletion/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();


        boolean success6 = JsonPath.read(response6.body().asString(), "$.success");
        Assert.assertTrue(success6);

        String description6 = JsonPath.read(response6.body().asString(), "$.description");
        assertEquals("Site deleted successfully.", description6);


// --------------------NETWORKS AND NETWORK GROUPS-------------------------------------------------
        //create network 1
        String networkUrls="https://dev.qa.xcloudiq.com/resource/api/v1/resources/networks/";
        String createnetworkBody = FileUtils.readFileToString(new File(FileNameConstants.POST_NETWORK_BODY));
        Response response7 = RestAssured
                .given().contentType(ContentType.JSON)
                .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                .header("x-csrftoken",csrf_token)
                .body(createnetworkBody)
                .baseUri(networkUrls)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        //verify if success is true
        boolean success7= JsonPath.read(response7.body().asString(),"$.success");
        Assert.assertTrue(success7);


        //verify the description of the response
        String description7= JsonPath.read(response4.body().asString(),"$.description");
        assertEquals("Network created successfully.",description7);

        id2= JsonPath.read(response7.body().asString(),"$.payload.id");

        //create network 2
        String createnetworkBody2 = FileUtils.readFileToString(new File(FileNameConstants.POST_NETWORK_BODY2));
        Response response8 = RestAssured
                .given().contentType(ContentType.JSON)
                .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                .header("x-csrftoken",csrf_token)
                .body(createnetworkBody2)
                .baseUri(networkUrls)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println(response8.body().asString());

        //verify if success is true
        boolean success8= JsonPath.read(response5.body().asString(),"$.success");
        Assert.assertTrue(success8);

        //verify the description of the response
        String description8= JsonPath.read(response5.body().asString(),"$.description");
        assertEquals("Network created successfully.",description8);

        id3= JsonPath.read(response2.body().asString(),"$.payload.id");

        //Get request to check both networks
        String url="https://dev.qa.xcloudiq.com/resource/api/v1/resources/networks/?limit=12&offset=0";
        Response response9 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                .baseUri(url)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println(response9.getBody().asString());

        boolean success9 = JsonPath.read(response9.body().asString(), "$.success");
        Assert.assertTrue(success9);
        String jsonResponse = response9.getBody().asString();

        DocumentContext context = JsonPath.parse(jsonResponse);

        // Use JsonPath to extract the 'payload.networks' array
        Object networks = context.read("$.payload.networks");

        // Convert to a string for easier processing
        String networkList = networks.toString();

        // Assert that "network demo 1" is present
        assertTrue("network demo 1 is present", networkList.contains("network demo 1"));

        // Assert that "network demo 2" is present
        assertTrue("network demo 2 is present", networkList.contains("network demo 2"));

        //create network group using networks created

        String networkUrl = "https://dev.qa.xcloudiq.com/resource/api/v1/resources/network-groups/";


        Response response10 = RestAssured
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
        boolean success10 = JsonPath.read(response10.body().asString(), "$.success");
        Assert.assertTrue(success10);

        //verify the description of the response
        String description10 = JsonPath.read(response8.body().asString(), "$.description");
        assertEquals("Network group created successfully", description10);

        String id8 = JsonPath.read(response2.body().asString(), "$.payload.id");

        //Delete network group
        Response response11 = RestAssured.given()
                .header("Cookie", "api_access_token=" + api_token + "; oauth2AccessToken=" + oauth_token + ";csrftoken=" + csrf_token)
                .header("x-csrftoken", csrf_token)
                .baseUri("https://dev.qa.xcloudiq.com/resource/api/v1/resources/network-groups/")
                .when()
                .delete("/" + id8 + "/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();


        boolean success11 = JsonPath.read(response9.body().asString(), "$.success");
        Assert.assertTrue(success11);

        String description11 = JsonPath.read(response11.body().asString(), "$.description");
        assertEquals("Network group deleted successfully", description11);

        //Get network groups
        String networkgroupsUrl = "https://dev.qa.xcloudiq.com/resource/api/v1/resources/network-groups/?limit=12&offset=0";
        Response response12 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Cookie", "api_access_token=" + api_token + "; oauth2AccessToken=" + oauth_token + ";csrftoken=" + csrf_token)
                .baseUri(networkgroupsUrl)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println(response12.getBody().asString());

        boolean success12 = JsonPath.read(response12.body().asString(), "$.success");
        Assert.assertTrue(success12);
        String jsonResponse10 = response12.getBody().asString();

        DocumentContext context2 = JsonPath.parse(jsonResponse10);

        // Use JsonPath to extract the 'payload.networks' array
        Object networks2 = context2.read("$.payload..network_groups");

        // Convert to a string for easier processing
        String networkList2 = networks2.toString();

        // Assert that "network group" is present
        assertTrue("network group is present", networkList2.contains("network group"));


        //Delete network 1
        Response response13 = RestAssured.given()
                .header("Cookie", "api_access_token=" + api_token + "; oauth2AccessToken=" + oauth_token + ";csrftoken=" + csrf_token)
                .header("x-csrftoken", csrf_token)
                .baseUri("https://dev.qa.xcloudiq.com/resource/api/v1/resources/networks")
                .when()
                .delete("/" + id2 + "/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        boolean success13 = JsonPath.read(response11.body().asString(), "$.success");
        Assert.assertTrue(success13);

        String description13 = JsonPath.read(response11.body().asString(), "$.description");
        assertEquals("Network deleted successfully.", description13);

        //Delete network 2
        Response response14 = RestAssured.given()
                .header("Cookie", "api_access_token=" + api_token + "; oauth2AccessToken=" + oauth_token + ";csrftoken=" + csrf_token)
                .header("x-csrftoken", csrf_token)
                .baseUri("https://dev.qa.xcloudiq.com/resource/api/v1/resources/networks")
                .when()
                .delete("/" + id3 + "/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        boolean success14 = JsonPath.read(response14.body().asString(), "$.success");
        Assert.assertTrue(success14);

        String description14 = JsonPath.read(response14.body().asString(), "$.description");
        assertEquals("Network deleted successfully.", description14);


        // --------------------USERS AND USER GROUPS-------------------------------------------------
        String accessgroupURL="https://dev.qa.xcloudiq.com/resource/api/v1/access-group/";
        String createUserBody = FileUtils.readFileToString(new File(FileNameConstants.POST_USER_BODY));
        Response response15 = RestAssured.given().contentType(ContentType.JSON)
                .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                .header("x-csrftoken",csrf_token)
                .body(createUserBody)
                .baseUri(accessgroupURL)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println(response15.getBody().asString());

        boolean success15 = JsonPath.read(response15.body().asString(), "$.success");
        Assert.assertTrue(success15);

        String description15 = JsonPath.read(response15.body().asString(), "$.description");
        assertEquals("Access Group created successfully.", description13);

       String id13=JsonPath.read(response15.body().asString(),"$.payload.id");

       //check usergroups
        String UserGroupURL="https://dev.qa.xcloudiq.com/resource/api/v1/access-group/?limit=12&offset=0";
        Response response16= RestAssured.given()
                .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                .header("x-csrftoken",csrf_token)
                .baseUri(UserGroupURL)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println(response16.getBody().asString());
        var jsonPath2=response16.jsonPath();

        List<String> usergroups= jsonPath2.getList("payload.access_groups.name");

        boolean usergroupExists= usergroups.contains("demo");
        assertTrue(usergroupExists);

        int numberOfuserGroups= usergroups.size();
        System.out.println("The number of user groups are "+numberOfuserGroups);

        Response response17 = RestAssured.given()
                .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                .header("x-csrftoken",csrf_token)
                .baseUri(accessgroupURL)
                .when()
                .delete(id13+"/delete/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();


        boolean success17 = JsonPath.read(response17.body().asString(), "$.success");
        Assert.assertTrue(success17);

        String description17 = JsonPath.read(response17.body().asString(), "$.description");
        assertEquals("User group deleted successfully.", description17);



    } catch (IOException e) {
    e.printStackTrace();
} catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    }
}
