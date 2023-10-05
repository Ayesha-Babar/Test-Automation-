package com.testautomation.apitesting.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import pojos.BookingDates;
import pojos.Bookings;
import utils.FileNameConstants;

import java.io.File;
import java.io.IOException;

public class Postapirequestusingpojos {
    @Test
    public void postapirequest() {
        try {
           String jsonschema= FileUtils.readFileToString(new File(FileNameConstants.JSON_SCHEME),"UTF-8");

            BookingDates bookingdates = new BookingDates("2023-03-25", "2023-03-30");
            Bookings bookings = new Bookings("ayesha", "babar", "breakfast", 1000, true, bookingdates);

            //serialise java classes into json objects using jackson
            ObjectMapper objectmapper = new ObjectMapper();
            String requestbody = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookings);
            System.out.println(requestbody);

            //deserialise json objects into java class object type
            Bookings bookingDetails=objectmapper.readValue(requestbody, Bookings.class);
            System.out.println(bookingDetails.getFirstname());
            System.out.println(bookingDetails.getTotalprice());

            System.out.println(bookingDetails.getBookingdates().getCheckin());
            System.out.println(bookingDetails.getBookingdates().getCheckout());

            Response response=
                    RestAssured.
                    given()
                    .contentType(ContentType.JSON)
                    .body(requestbody)
                    .baseUri("https://restful-booker.herokuapp.com/booking")
                    .when()
                    .post()
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();

            int bookingId=response.path("bookingid");
           // System.out.println(jsonschema);

            RestAssured.given().contentType(ContentType.JSON)
                    .baseUri("https://restful-booker.herokuapp.com/booking")
                    .when()
                    .get("/{bookingId}",bookingId)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body(JsonSchemaValidator.matchesJsonSchema(jsonschema));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
