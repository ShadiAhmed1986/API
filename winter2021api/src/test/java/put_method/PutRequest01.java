package put_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData02;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class PutRequest01 extends JsonPlaceHolderBaseUrl {

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
        //1) Set the url
        spec.pathParams("first","todos","second",170);

        //2) Set the expected data
        JsonPlaceHolderTestData02 expected = new JsonPlaceHolderTestData02();

        //3) Send the Put Request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expected.expectedDataSetUp()).when().put("/{first}/{second}");
        response.prettyPrint();

        //4) Assert the output

        Map<String,Object> actual = response.as(HashMap.class);
        System.out.println(actual);

        assertEquals(expected.expectedDataSetUp().get("completed"),actual.get("completed"));
        assertEquals(expected.expectedDataSetUp().get("title"),actual.get("title"));
        assertEquals(expected.expectedDataSetUp().get("userId"),actual.get("userId"));

    }
}
