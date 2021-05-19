package patch_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData02;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class ReviewPatchRequest extends JsonPlaceHolderBaseUrl {


    /*
        When
	 		I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "title": "Tidy your room"
										   }
	   Then
	   	   Status code is 200
	   	   And response body is like  {
									    "userId": 10,
									    "title": "Tidy your room",
									    "completed": true,
									    "id": 198
									  }
     */

    @Test
    public void patch01(){
        //1) Set the URL
        spec.pathParams("first","todos","second",171);

        //2) Set the expected data
        JsonPlaceHolderTestData02 expectedData = new JsonPlaceHolderTestData02();

        //3) Send patch request
        Response response =
                given().
                        spec(spec).
                        contentType(ContentType.JSON).
                        body(expectedData.expectedPatchDataSetUp()).
                        when().
                        patch("/{first}/{second}");
        response.prettyPrint();

        //4) Assert
        //1st Way
        Map<String ,Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData.expectedPatchDataSetUp().get("userId"),actualData.get("userId"));
        assertEquals(expectedData.expectedPatchDataSetUp().get("title"),actualData.get("title"));
        assertEquals(expectedData.expectedPatchDataSetUp().get("completed"),actualData.get("completed"));

        //2nd Way:
        response.
                then().
                assertThat().
                statusCode(200).
                body("title",equalTo(expectedData.expectedPatchDataSetUp().get("title")),
                        "completed",equalTo(expectedData.expectedPatchDataSetUp().get("completed")),
                        "userId",equalTo(expectedData.expectedPatchDataSetUp().get("userId")));
    }
}
