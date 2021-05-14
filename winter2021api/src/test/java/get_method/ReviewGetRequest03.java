package get_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReviewGetRequest03 extends JsonPlaceHolderBaseUrl {

     /*
        When
		 	I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/23
		    And Accept type is “application/JSON”
		 Then
		    HTTP Status Code should be 200
		    And Response format should be “application/json”
		    And “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		    And “completed” is false
		    And “userId” is 2
     */

    @Test
    public void get03(){
        //1) Set the url
        spec.pathParams("first","todos","second","23");

        //2) Set the expected data

        //3) Send request
        Response response = given().spec(spec).accept("application/json").when().get("/{first}/{second}");
        response.prettyPrint();

        //4) Assert
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),"userId",equalTo(2));
    }
}
