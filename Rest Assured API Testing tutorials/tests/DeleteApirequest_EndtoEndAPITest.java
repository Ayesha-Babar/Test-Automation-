package com.testautomation.apitesting.tests;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.FileNameConstants;

import java.io.File;
import java.io.IOException;

public class DeleteApirequest_EndtoEndAPITest extends BaseTest
{
    @Test
    public void deleteapi()
    {

        try
        {
            String postApirequestBody = FileUtils.readFileToString(new File(FileNameConstants.POST_API_REQUEST_BODY));
            String putApirequestBody = FileUtils.readFileToString(new File(FileNameConstants.PUT_API_REQUEST_BODY));
            String tokenApirequestBody = FileUtils.readFileToString(new File(FileNameConstants.TOKEN_REQUEST_BODY));
            String patchApirequestBody= FileUtils.readFileToString(new File(FileNameConstants.PATCH_API_REQUEST_BODY));

            //post request
            Response response= RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .body(postApirequestBody)
                    .baseUri("https://restful-booker.herokuapp.com/booking/")
                    .when()
                    .post()
                    .then()
                    .assertThat()
                    .statusCode(200).extract().response();

            JSONArray jsonarray= JsonPath.read(response.body().asString(),"$.booking..firstname");
            String firstname =(String)jsonarray.get(0);
            Assert.assertEquals(firstname,"ayesha");

            JSONArray jsonarray2=JsonPath.read(response.body().asString(),"$.booking..lastname");
            String lastname= (String)jsonarray2.get(0);
            Assert.assertEquals(lastname,"babar");


            JSONArray jsonarray3=JsonPath.read(response.body().asString(),"$.booking.bookingdates..checkin");
            String checkin= (String)jsonarray3.get(0);
            Assert.assertEquals(checkin,"2018-01-01");

            //extract the bookingid
            int bookingid=  JsonPath.read(response.body().asString(),"$.bookingid");

            //get request
            RestAssured.given()
                    .contentType(ContentType.JSON).baseUri("https://restful-booker.herokuapp.com/booking/")
                    .when()
                    .get("{bookingId}",bookingid)
                    .then().assertThat()
                    .statusCode(200);
            System.out.println(bookingid);

            //token generation
            Response tokenApiresponse= RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .body(tokenApirequestBody)
                    .baseUri("https://restful-booker.herokuapp.com/auth")
                    .when()
                    .post()
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract()
                    .response();
            String token= JsonPath.read(tokenApiresponse.body().asString(),"$.token");

            //put request
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(putApirequestBody)
                    .header("Cookie","token="+token)
                    .baseUri("https://restful-booker.herokuapp.com/booking/")
                    .when()
                    .put("{bookingId}",bookingid)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("firstname", Matchers.equalTo("smith"))
                    .body("lastname",Matchers.equalTo("jones"));

            //patch request
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(patchApirequestBody)
                    .header("Cookie","token="+token)
                    .baseUri("https://restful-booker.herokuapp.com/booking/")
                    .when()
                    .patch("{bookingId}",bookingid)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("firstname",Matchers.equalTo("patch"));

            //delete request
            Response response2 =
                    RestAssured
                            .given()
                            .contentType(ContentType.JSON)
                            .header("Cookie","token="+token)
                            .baseUri("https://restful-booker.herokuapp.com/booking")
                            .when()
                            .delete("{bookingId}",bookingid)
                            .then()
                            .assertThat()
                            .statusCode(201)
                            .extract()
                            .response();

            Assert.assertTrue(response2.getBody().asString().contains("Created"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}

