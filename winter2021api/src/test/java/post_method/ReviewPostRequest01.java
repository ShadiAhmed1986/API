package post_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import test_data.ReviewHerokuappTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ReviewPostRequest01 extends HerokuappBaseUrl {

    /*
        When
	 		I send POST Request to the Url https://restful-booker.herokuapp.com/booking
	 		with the request body {
								    "firstname": "Selim",
								    "lastname": "Ak",
								    "totalprice": 11111,
								    "depositpaid": true,
								    "bookingdates": {
								        "checkin": "2020-09-09",
								        "checkout": "2020-09-21"
								     }
								  }
	 	Then
	 		Status code is 200
	 		And response body should be like {
											    "bookingid": 11,
											    "booking": {
											        "firstname": "Selim",
											        "lastname": "Ak",
											        "totalprice": 11111,
											        "depositpaid": true,
											        "bookingdates": {
											            "checkin": "2020-09-09",
											            "checkout": "2020-09-21"
											        }
											    }
											 }
     */

    @Test
    public void post01(){
        //1) Set the URL
        spec.pathParam("first","booking");

        //2) Set the expected data
        ReviewHerokuappTestData expectedData = new ReviewHerokuappTestData();

        //3) Sent the post request
        Response response =
                given().
                        spec(spec).
                        contentType(ContentType.JSON).
                        body(expectedData.expectedDataSetUp()).
                        post("/{first}");
        response.prettyPrint();

        //Assert
        //1.Way : by using Json
        JsonPath json = response.jsonPath();

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.expectedDataSetUp().get("firstname"), json.getString("booking.firstname"));
        assertEquals(expectedData.expectedDataSetUp().get("lastname"),json.getString("booking.lastname"));
        assertEquals(expectedData.bookingDates().get("checkin"),json.getString("booking.bookingdates.checkin"));

        //2.Way: By using GSON
        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData.bookingDates().get("checkout"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));
        assertEquals(expectedData.expectedDataSetUp().get("depositpaid"),((Map) actualData.get("booking")).get("depositpaid"));
    }
}
