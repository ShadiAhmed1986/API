package pojo_tests;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.TodosPojo;
import utilities.JsonUtil;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
public class PostRequestPojo01 extends JsonPlaceHolderBaseUrl {
    /*
        When
            I send POST Request to the URL https://jsonplaceholder.typicode.com/todos
            with Post Request body  {
                                        "userId": 21,
                                        "id": 201,
                                        "title": "Tidy your room",
                                        "completed": false
                                     }
        Then
            Status code is 201
            And response body is like {
                                        "userId": 21,
                                        "id": 201,
                                        "title": "Tidy your room",
                                        "completed": false
                                      }
     */
    @Test
    public void post01(){
        //Set the url
        spec.pathParam("todosName","todos");

        //Set the expected data
        TodosPojo expectedPojo = new TodosPojo(21,"Tidy your room",false);
        System.out.println(expectedPojo);
        System.out.println(expectedPojo.getUserId());
        System.out.println(expectedPojo.getTitle());
        System.out.println(expectedPojo.isCompleted());

        //Send the request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedPojo).post("/{todosName}");
        response.prettyPrint();

        //Use GSON for deserialization (json->Java)
        TodosPojo actualPojo = response.as(TodosPojo.class);
        System.out.println("Actual data from GSON: "+actualPojo);
        assertEquals(201, response.statusCode());
        assertEquals(expectedPojo.getUserId(),actualPojo.getUserId());
        assertEquals(expectedPojo.getTitle(),actualPojo.getTitle());
        assertEquals(expectedPojo.isCompleted(),actualPojo.isCompleted());

        //Use Object Mapper for deserialization
        TodosPojo actualPojo2 = JsonUtil.convertJsonToJava(response.asString(),TodosPojo.class);
        System.out.println("Actual data from object mapper: "+ actualPojo2);
        assertEquals(201, response.statusCode());
        assertEquals(expectedPojo.getUserId(),actualPojo2.getUserId());
        assertEquals(expectedPojo.getTitle(),actualPojo2.getTitle());
        assertEquals(expectedPojo.isCompleted(),actualPojo2.isCompleted());
    }
}