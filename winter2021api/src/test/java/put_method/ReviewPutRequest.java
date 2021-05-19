package put_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData02;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ReviewPutRequest extends JsonPlaceHolderBaseUrl {

    /*
        When
	 		I send PUT Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    “userId”: 21,
										    “title”: “Wash the dishes”,
										    “completed”: false
										   }
	   Then
	   	   Status code is 200
	   	   And response body is like   {
									    “userId”: 21,
									    “title”: “Wash the dishes”,
									    “completed”: false,

     */

    @Test
    public void put01(){
        //1) Set the URL
        spec.pathParams("first","todos","second",171);

        //2) Set the expected data
        JsonPlaceHolderTestData02 expectedData = new JsonPlaceHolderTestData02();

        //3) Send put request
        Response response =
                given().
                        spec(spec).
                        contentType(ContentType.JSON).
                        body(expectedData.expectedDataSetUp()).put("/{first}/{second}");
        response.prettyPrint();
        //4) Assert
        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData.expectedDataSetUp().get("completed"),actualData.get("completed"));
        assertEquals(expectedData.expectedDataSetUp().get("title"),actualData.get("title"));
        assertEquals(expectedData.expectedDataSetUp().get("userId"),actualData.get("userId"));
    }
}
