package com.testautomation.apitesting.tests;

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

public class PostapirequestusingFile extends BaseTest {
    @Test
    public void postApiRequest()
    {
        try
        {
            String postApirequestBody = FileUtils.readFileToString(new File(FileNameConstants.POST_API_REQUEST_BODY));
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

            JSONArray jsonarray=JsonPath.read(response.body().asString(),"$.booking..firstname");
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

            RestAssured.given()
                    .contentType(ContentType.JSON).baseUri("https://restful-booker.herokuapp.com/booking/")
                    .when()
                    .get("{bookingId}",bookingid)
                    .then().assertThat()
                    .statusCode(200);
            System.out.println(bookingid);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
