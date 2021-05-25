package get_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class GetRequest09nt extends HerokuappBaseUrl {

    /*
        When
	 		I send GET Request to https://restful-booker.herokuapp.com/booking/1
	 	Then
	 		Response body should be like that;
	 		{
			    “firstname”: “Mark”,
			    “lastname”: “Smith”,
			    “totalprice”: 762,
			    “depositpaid”: false,
			    “bookingdates”: {
			        “checkin”: “2018-04-05”,
			        “checkout”: “2021-01-23”
			     }
			}
     */

    @Test
    public void get01(){
        //1)Set the URL
        spec.pathParams("first", "booking",
                "second", 1);

        //2)Set the expected data
        //Create an inner map
        Map<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2019-12-17");
        bookingdates.put("checkout", "2020-03-01");

        //Create the outer map
        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname", "Sally");
        expectedDataMap.put("lastname", "Smith");
        expectedDataMap.put("totalprice", 688);
        expectedDataMap.put("depositpaid", true);
        expectedDataMap.put("bookingdates", bookingdates);

        System.out.println(expectedDataMap);

        //3)Send the request
        Response response =
                        given()
                        .spec(spec)
                        .accept(ContentType.JSON)
                        .when()
                        .get("/{first}/{second}");
        response.prettyPrint();

        //Use GSON for DE-Serialization
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        //4) Assert the data
        assertEquals(response.statusCode(),200);
        assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"), ((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"), ((Map)actualDataMap.get("bookingdates")).get("checkout"));

    }

}
