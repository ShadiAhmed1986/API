package object_mapper;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utilities.JsonUtil;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ObjectMapper01 extends JsonPlaceHolderBaseUrl {

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
        //1) Set the URL
        spec.pathParams("first","todos","second",198);


        //2)Set the expected data
        JsonPlaceHolderTestData expectedObj = new JsonPlaceHolderTestData();

        HashMap<String,Object> expectedMap =  JsonUtil.convertJsonToJava(expectedObj.expected, HashMap.class);
        System.out.println(expectedMap);

        //3) Send the request
        Response response =
                        given()
                        .spec(spec)
                        .when().get("/{first}/{second}");
        response.prettyPrint();

        HashMap<String,Object>  actualMap = JsonUtil.convertJsonToJava(response.asString(),HashMap.class);
        System.out.println(actualMap);

        //4) Assertion
        response.then().assertThat().statusCode(200);
        assertEquals(expectedMap.get("userId"),actualMap.get("userId"));
        assertEquals(expectedMap.get("title"),actualMap.get("title"));
        assertEquals(expectedMap.get("completed"),actualMap.get("completed"));
    }

}
