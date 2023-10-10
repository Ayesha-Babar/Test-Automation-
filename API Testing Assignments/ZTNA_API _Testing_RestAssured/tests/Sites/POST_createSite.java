package Sites;

import com.fasterxml.jackson.databind.ser.Serializers;
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
import Login.POST_ztaLogin;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class POST_createSite extends BaseTest
{
    String sitesUrl="https://dev.qa.xcloudiq.com/resource/api/v1/resources/sites/";
     @Test
    public void createsites()
     {
         POST_ztaLogin login= new POST_ztaLogin();
         login.zta();
         String csrf_token= login.getCsrf_token();
         String oauth_token= login.getOauthtoken2();
         String api_token= login.getApitoken2();
         System.out.println(csrf_token);
         System.out.println(oauth_token);
         System.out.println(api_token);

         try{

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


             var id= JsonPath.read(response2.body().asString(),"$.payload..id");
             System.out.println(id);


             //verify if success is true
             boolean success= JsonPath.read(response2.body().asString(),"$.success");
             Assert.assertTrue(success);

             //verify the description of the response
             String description= JsonPath.read(response2.body().asString(),"$.description");
             assertEquals("Site created successfully.",description);

             System.out.println(response2.getBody().asString());


         }
         catch(IOException e)
         {
             e.printStackTrace();
         }
     }
}
