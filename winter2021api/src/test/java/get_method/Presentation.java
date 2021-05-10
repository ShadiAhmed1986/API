package get_method;

import base_urls.PresentationUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Presentation extends PresentationUrl {

    /*
      When
            I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos
            And Accept type is “application/json”
      Then
            HTTP Status Code should be 200
      And
            Response format should be "application/json"
      And
            there should be 200 todos
      And
            "quis eius est sint explicabo" should be one of the todos
      And
            2, 7, and 9 should be among the userIds
   */

    @Test
    public void get(){

        //1) Set the URL
        //String url = "https://jsonplaceholder.typicode.com/todos";
        spec.pathParam("first","todos");

        //2) Set the expected data

        //3) Send the request
        Response response = given().spec(spec).contentType("application/json").when().get("/{first}");
        response.prettyPrint();

        //4) Assert the data
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("id",hasSize(200));
    }




}
