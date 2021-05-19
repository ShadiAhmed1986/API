package delete_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class DeleteRequest01 extends JsonPlaceHolderBaseUrl {

    /*
        When
            I send DELETE Request to the Url https://jsonplaceholder.typicode.com/todos/171
        Then
            Status code is 200
            And Response body is {}
    */

    @Test
    public void delete01(){
        //1) Set the url
        spec.pathParams("first","todos","second",171);

        //2) Set the expected data
        Map<String,Object> expected = new HashMap<>();

        //3) Send delete request
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        //4) Assert
       //Use GSON for De-Serialization
        Map<String,Object> actual = response.as(HashMap.class);

        response.then().assertThat().statusCode(200);
        assertEquals(expected.get(""),actual.get(""));
        assertEquals(expected,actual);
        assertEquals(expected.size(),actual.size());
    }
}
