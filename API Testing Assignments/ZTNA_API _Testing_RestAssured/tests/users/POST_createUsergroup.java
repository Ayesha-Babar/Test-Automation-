package users;

import Login.POST_ztaLogin;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FileNameConstants;

import java.io.File;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class POST_createUsergroup {
    public static String id;
    @Test
    public void test() {
        try {
            String accessgroupURL="https://dev.qa.xcloudiq.com/resource/api/v1/access-group/";
            POST_ztaLogin login= new POST_ztaLogin();
            login.zta();
            String csrf_token= login.getCsrf_token();
            String oauth_token= login.getOauthtoken2();
            String api_token= login.getApitoken2();
            String createUserBody = FileUtils.readFileToString(new File(FileNameConstants.POST_USER_BODY));
            Response response = RestAssured.given().contentType(ContentType.JSON)
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

            System.out.println(response.getBody().asString());

            boolean success = JsonPath.read(response.body().asString(), "$.success");
            Assert.assertTrue(success);

            String description = JsonPath.read(response.body().asString(), "$.description");
            assertEquals("Access Group created successfully.", description);

            id=JsonPath.read(response.body().asString(),"$.payload.id");


            Response response2 = RestAssured.given()
                    .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                    .header("x-csrftoken",csrf_token)
                    .baseUri(accessgroupURL)
                    .when()
                    .delete(id+"/delete/")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();


            boolean success2 = JsonPath.read(response.body().asString(), "$.success");
            Assert.assertTrue(success2);

            String description2 = JsonPath.read(response2.body().asString(), "$.description");
            assertEquals("User group deleted successfully.", description2);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getId()
    {
        return id;
    }
}
