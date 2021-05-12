package get_method;

import base_urls.JasonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class GetRequest08nt extends JasonPlaceHolderBaseUrl {

     /*
        De-Serialization: Converting Json Data to any Java Object is called "De-Serialization".
        Serialization: Converting Java Object to Json data is called "Serialization".
        To do De-Serialization and Serialization, we have 2 ways;
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
	  		And header “Connection” is “keep-alive”
	  		And header “Server” is “cloudflare”
     */

    @Test
    public void get01(){
        //1) Set the url
        spec.pathParams("first","todos","second",2);

        //2) Set the expected data
        Map<String,Object>expectedDataMap = new HashMap<>();
        expectedDataMap.put("Status code",200);
        expectedDataMap.put("completed",false);
        expectedDataMap.put("userId",1);
        expectedDataMap.put("title","quis ut nam facilis et officia qui");
        expectedDataMap.put("Connection","keep-alive");
        expectedDataMap.put("Server","cloudflare");

        //3) Send request
        Response response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String,Object>actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        //4)Assert
        //Status code is 200
        assertEquals(expectedDataMap.get("Status code"),response.statusCode());
        //And “completed” is false
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
        //And “userId” is 1
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        //And “title” is “quis ut nam facilis et officia qui”
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        //And header “Via” is “1.1 vegur”
        assertEquals(expectedDataMap.get("Connection"),response.getHeader("Connection"));
        //And header “Server” is “cloudflare”
        assertEquals(expectedDataMap.get("Server"),response.getHeader("Server"));

    }
}
