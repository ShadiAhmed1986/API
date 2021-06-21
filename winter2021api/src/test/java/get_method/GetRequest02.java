package get_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.requestSpecification;
import static org.junit.Assert.*;

public class GetRequest02 extends HerokuappBaseUrl {

    /*
        When
			    I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/1001
			Then
				HTTP Status code should be 404
			And
				Status Line should be HTTP/1.1 404 Not Found
			And
	            Response body contains “Not Found”
	        And
	            Response body does not contain “TechProEd”
	        And Server is "Cowboy"
     */

    @Test
    public void get02(){
        //1) Set the URL

        //NOT RECOMMENDED
        //String url = "https://restful-booker.herokuapp.com/booking/1001";

        spec.pathParams("first", "booking", "second", 1001);

        //2) Set the expected data

        //3) Send the request
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");

        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechProEd"));

        //assertEquals(firstParameter,secondParameter) - >
        // If first parameter matches with the second parameter you will get pass
        assertEquals(response.getHeader("Server"),"Cowboy");

        //How to see the status code and status line
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Status Line: " + response.statusLine());
    }
}
