package get_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;

public class ReviewGetRequest05 extends HerokuappBaseUrl {

    /*
        When
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking
	  	 Then
	  	    Status code is 200
	  	 And
	  		Among the data there should be someone whose first name is “Mark” and last name is “Ericsson”
     */

    @Test
    public void get05(){
        //1) Set the Url
        spec.pathParam("first","booking").
                queryParams("firstname","Susan","lastname","Ericsson");

        //2) Set the expected data

        //3) Send request
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4) Assert
        response.
                then().
                assertThat().
                statusCode(200);
    }

}
