package object_mapper;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utilities.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ReviewObjectMapper01 extends JsonPlaceHolderBaseUrl {

    /*
        When
            I send GET Request to the URL https://jsonplaceholder.typicode.com/todos/198
        Then
            Status code is 200
            And response body is like {
                                        "userId": 10,
                                        "id": 198,
                                        "title": "quis eius est sint explicabo",
                                        "completed": true
                                      }
    */

    @Test
    public void get01(){
        //Set the URL
        spec.pathParams("first","todos","second",198);

        //Set the expected data
        JsonPlaceHolderTestData jsonObj = new JsonPlaceHolderTestData();
        Map<String,Object> expectedDataMap = JsonUtil.convertJsonToJava(jsonObj.expected,HashMap.class);
        System.out.println(expectedDataMap);

        //Send Request
        Response response =
                        given()
                        .spec(spec)
                        .contentType(ContentType.JSON)
                        .when()
                        .get("/{first}/{second}");
        response.prettyPrint();

        //Assert
        Map<String,Object> actualDataMap = JsonUtil.convertJsonToJava(response.asString(),HashMap.class);
        System.out.println(actualDataMap);

        response.then().assertThat().statusCode(200);
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
    }
}
