package com.testautomation.apitesting.tests;

import io.restassured.RestAssured;
import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseTest;

public class PostApiRequest extends BaseTest
{
    @Test
    public void createBooking()
    {

        //prepare the request body
        JSONObject booking= new JSONObject();
        JSONObject bookingDates= new JSONObject();

        booking.put("firstname","ayesha");
        booking.put("lastname","babar");
        booking.put("totalprice",1000);
        booking.put("depositpaid","true");
        booking.put("additionalneeds","breakfast");
        booking.put("bookingdates",bookingDates);
        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        Response response=
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(booking.toString())
                .baseUri("https://restful-booker.herokuapp.com/booking")
                //.log().body()
                //.log().headers()
                .log().all()
                .when()
                .post()
                .then()
                .assertThat()
                //.log().body()
                //.log().headers()
                .log().all()
                //.log().ifValidationFails() , only logs details when test fails
                .statusCode(200)
                .body("booking.firstname", Matchers.equalTo("ayesha"))
                .body("booking.totalprice", Matchers.equalTo(1000))
                .body("booking.bookingdates.checkin", Matchers.equalTo("2018-01-01"))
                .extract()
                .response();

        //create API, create bookingid variable
        int bookingID=response.path("bookingid");
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParams("bookingid",bookingID)
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .when()
                .get("{bookingid}")
                .then()
                .assertThat()
                .statusCode(200)
                .body("firstname",Matchers.equalTo("ayesha"))
                .body("lastname",Matchers.equalTo("babar"));



    }
}
