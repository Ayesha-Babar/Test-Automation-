package Networks;

import Login.POST_ztaLogin;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.FileNameConstants;

import java.io.File;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class POST_createNetworks extends BaseTest {
    public static String id2;
    public static String id3;
    @Test
    public void test() {

        try {
            //create network 1
            String networkUrls="https://dev.qa.xcloudiq.com/resource/api/v1/resources/networks/";
            POST_ztaLogin login= new POST_ztaLogin();
            login.zta();
            String csrf_token= login.getCsrf_token();
            String oauth_token= login.getOauthtoken2();
            String api_token= login.getApitoken2();
            String createnetworkBody = FileUtils.readFileToString(new File(FileNameConstants.POST_NETWORK_BODY));
            Response response = RestAssured
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
            boolean success= JsonPath.read(response.body().asString(),"$.success");
            Assert.assertTrue(success);


            //verify the description of the response
            String description= JsonPath.read(response.body().asString(),"$.description");
            assertEquals("Network created successfully.",description);

            id2= JsonPath.read(response.body().asString(),"$.payload.id");

           //create network 2
            String createnetworkBody2 = FileUtils.readFileToString(new File(FileNameConstants.POST_NETWORK_BODY2));
                Response response2 = RestAssured
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

                System.out.println(response2.body().asString());

                //verify if success is true
                boolean success2= JsonPath.read(response2.body().asString(),"$.success");
                Assert.assertTrue(success2);

                //verify the description of the response
                String description2= JsonPath.read(response2.body().asString(),"$.description");
                assertEquals("Network created successfully.",description2);

                id3= JsonPath.read(response2.body().asString(),"$.payload.id");





            } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getId2()
    {
        return id2;
    }

    public String getId3()
    {
        return  id3;
    }
}
