package get_method;

import base_urls.JasonPlaceHolderBaseUrl;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GetRequest03 extends JasonPlaceHolderBaseUrl {

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
        //1) Set the URL
        //String url ="https://jsonplaceholder.typicode.com/todos/23";// Not recommended
        spec.pathParams("first","todos","second","23");

        //2)Set the expected data

        //3) Send the request
        Response response = given().spec(spec).accept("application/JSON").when().get("/{first}/{second}");
        response.prettyPrint();
        System.out.println("Status code: " + response.getStatusCode());

        //4) Assert
        /*
            When a test fails, if JAVA doesn't execute the next steps, it's called "Hard assertion(Assertion)"
            But there is another assertion,which is "Soft Assertion(Verification)".
            It executes all tests and gives you a report about the past ones and failed ones.
         */

        //1.Way
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/JSON").
                body("title", Matchers.equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", Matchers.equalTo(false)).
                body("userId", Matchers.equalTo(2));

        /*
            If you use body() method for every step, it uses "Hard Assertion"
            If you use just a single body() method with multiple test steps,
            it gives you report for every failed test("Soft Assertion")
         */

        //2.Way
        response.
               then().assertThat().
               statusCode(200).
               contentType("application/JSON").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId",equalTo(2));

        //3.Way
        //HTTP Status Code should be 200
        //assertEquals(expected,actual)
        assertEquals(200,response.getStatusCode());
        assertEquals("Status code doesn't match",200,response.getStatusCode());

        //Response format should be “application/json”
        assertEquals("application/json; charset=utf-8",response.contentType());

        //“title” is “et itaque necessitatibus maxime molestiae qui quas velit”
        assertTrue(response.asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));

        //“completed” is false
        assertTrue(response.asString().contains("\"completed\": false"));

        //“userId” is 2
        assertTrue(response.asString().contains("\"userId\": 2"));
    }
}
