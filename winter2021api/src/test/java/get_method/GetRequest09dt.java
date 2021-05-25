package get_method;

import base_urls.JsonPlaceHolderBaseUrl;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class GetRequest09dt extends JsonPlaceHolderBaseUrl {

    /*
        De-Serialization: Converting Json Data to any Java Object is called "De-Serialization".
        Serialization: Converting Java Object to Json data is called "Serialization".

        To do De-Serialization and Serialization, we have 2 ways:
        1)Using GSON
        2)Using Object Mapper
    */

    /*
        When
	  		I send GET Request to https://jsonplaceholder.typicode.com/todos/2
	  Then
	  		Status code is 200
	  		And “completed” is false
	  		And “userId” is 1
	  		And “title” is “quis ut nam facilis et officia qui”
	  		And header “Via” is “1.1 vegur”
	  		And header “Server” is “cloudflare”
     */

    @Test
    public void get01(){

        //1) Set the url
        spec.pathParams("first","todos","second",2);

        //2) Set the expected data - get the data from test data class by creating an object
        JsonPlaceHolderTestData expectedDataObj = new JsonPlaceHolderTestData();

        Map<String,Object> expectedDataMap = expectedDataObj.setUpData();

        //3) Send the request
        Response response =
                        given()
                        .spec(spec)
                        .accept(ContentType.JSON)
                        .when().get("/{first}/{second}");
        response.prettyPrint();

        //4) Assertion
        Map<String,Object> actualDataMap = response.as(HashMap.class);

        assertEquals(expectedDataMap.get("statusCode"),response.statusCode());
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("Via"),response.getHeader("Via"));
        assertEquals(expectedDataMap.get("Server"),response.getHeader("Server"));


        //GSON : Serialization : Converting Java object to Json Data
        Gson gson = new Gson();
        String jsonFromJavaObj =  gson.toJson(actualDataMap);
        System.out.println("Java to Json: "+ jsonFromJavaObj);
    }

}
