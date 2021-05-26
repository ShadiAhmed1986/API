package object_mapper;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuappTestData;
import utilities.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ReviewObjectMapper02 extends HerokuappBaseUrl {

    /*
        When
                I send GET Request to the URL https://restful-booker.herokuapp.com/booking/2
            Then
                Status code is 200
                And response body is like {
                                            "firstname": "Mark",
                                            "lastname": "Ericsson",
                                            "totalprice": 726,
                                            "depositpaid": true,
                                            "bookingdates": {
                                                "checkin": "2015-08-07",
                                                "checkout": "2020-10-25"
                                             }
                                          }
     */

    @Test
    public void get01(){
        //1.Set the URL
        spec.pathParams("first","booking","second",2);

        //2.Set the expected data
        HerokuappTestData expectedData = new HerokuappTestData();

        Map<String,Object> expectedDataMap = JsonUtil.convertJsonToJava(expectedData.expected, HashMap.class);
        System.out.println(expectedDataMap);

        //3.Send GET request
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //4.Assert
        Map<String,Object> actualDataMap = JsonUtil.convertJsonToJava(response.asString(),HashMap.class);
        System.out.println(actualDataMap);

        response.then().assertThat().statusCode(200);
        //assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
        //assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("lastname"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"),((Map)actualDataMap.get("bookingdates")).get("checkin"));



    }
}
