package get_method;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest01 {

    /*
        In API test cases and automation scripts, we use "Given" , "When", "Then" and "And"
        "Given" : It declares prerequisites
        "When"  : It declares the action which user will perform
        "Then"  : It declares outputs
        "And"   : It can be used after  "Given", after "When" and after "Then" for multiple actions
     */

    /*
      When
		     I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3
		 Then
		     HTTP Status Code should be 200
		 And
		     Content Type should be JSON
		 And
		     Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void Get01(){

        //1) Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/3";

        //2) Set the expected data

        //3) Type automation script to send request
        Response response = given().when().get(url);

        response.prettyPrint();

        //4) Assert the output
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

        //How to print content-type, status code, status line, etc. on the console...
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Content type: " + response.getContentType());
        System.out.println("Status Line: " + response.statusLine());
        System.out.println("All Headers:\n " + response.getHeaders());
        System.out.println("Server :\n" + response.getHeader("Server"));
        System.out.println("Time : " + response.getTime());
    }

}
