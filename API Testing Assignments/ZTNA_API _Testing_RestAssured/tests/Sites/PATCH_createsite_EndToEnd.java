package Sites;

import Login.POST_ztaLogin;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.FileNameConstants;

import java.io.File;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class PATCH_createsite_EndToEnd extends BaseTest
{
     //POST REQUEST
        @Test
        public void test(){
       try{
           //post request
           String sitesUrl="https://dev.qa.xcloudiq.com/resource/api/v1/resources/sites/";
           POST_ztaLogin login= new POST_ztaLogin();
               login.zta();
               String csrf_token= login.getCsrf_token();
               String oauth_token= login.getOauthtoken2();
               String api_token= login.getApitoken2();


                   String createsiteBody= FileUtils.readFileToString(new File(FileNameConstants.CREATE_SITE_BODY));
                   Response response2= RestAssured
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

                  JSONArray id= JsonPath.read(response2.body().asString(),"$.payload..id");
                  String id2= (String) id.get(0);



           System.out.println(id2);

           //PATCH REQUEST
           String patchbody= FileUtils.readFileToString(new File(FileNameConstants.PATCH_CREATE_SITE_BODY));


           Response res=
                RestAssured.given()
                        .contentType(ContentType.JSON)
                        .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                        .header("x-csrftoken",csrf_token)
                        .body(patchbody)
                        .baseUri(sitesUrl)
                        .when()
                        .patch("/"+id2+"/")
                        .then()
                        .assertThat()
                        .statusCode(200).extract().response();
           JSONArray ID= JsonPath.read(response2.body().asString(),"$.payload..id");
           String ID2= (String) ID.get(0);


                //DELETE REQUEST
           Thread.sleep(2000);

           Response response = RestAssured.given()
                   .header("Cookie", "api_access_token=" +api_token+ "; oauth2AccessToken=" + oauth_token+";csrftoken="+csrf_token)
                   .header("x-csrftoken",csrf_token)
                   .baseUri(sitesUrl)
                   .when()
                   .delete("/"+ID2+"/hard-deletion/")
                   .then()
                   .assertThat()
                   .statusCode(200)
                   .extract().response();


           boolean success = JsonPath.read(response.body().asString(), "$.success");
           Assert.assertTrue(success);

           String description = JsonPath.read(response.body().asString(), "$.description");
           assertEquals("Site deleted successfully.", description);


            }
            catch(IOException e)
            {
                e.printStackTrace();
            } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
        }


    }


