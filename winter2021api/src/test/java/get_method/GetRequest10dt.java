package get_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuappTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class GetRequest10dt extends HerokuappBaseUrl {

    /*
     When
        I send GET Request to "https://restful-booker.herokuapp.com/booking/1"
     Then
        Response body should be like that;
        {
  {
    "firstname": "Mark",
    "lastname": "Brown",
    "totalprice": 870,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2016-05-10",
        "checkout": "2019-06-03"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void get01(){
        //Set the url
        spec.pathParams("first","booking","second",1);

        //Set the expected data
        HerokuappTestData expectedDataObj = new HerokuappTestData();
        expectedDataObj.setUpData();

        Map<String,Object> expectedDataMap = expectedDataObj.setUpData();

        //Send the request
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Assertion

        Map<String,Object>actualDataMap = response.as(HashMap.class);

//        //firstname
//        assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
//
//        //lastname
//        assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("lastname"));
//
//        //totalprice
//        assertEquals(expectedDataMap.get("totalprice"),actualDataMap.get("totalprice"));
//
//        //depositepaid
//        assertEquals(expectedDataMap.get("depositepaid"),actualDataMap.get("depositepaid"));

        //bookingdates
      //  assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"),((Map)actualDataMap.get("bookingdates")).get("checkin"));

      //  assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"),((Map)actualDataMap.get("bookingdates")).get("checkout"));

        assertEquals(expectedDataMap.get("additionalneeds"),actualDataMap.get("additionalneeds"));
    }


}
