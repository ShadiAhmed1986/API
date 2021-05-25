package patch_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData02;

import static io.restassured.RestAssured.given;

public class PatchRequest01 extends JsonPlaceHolderBaseUrl {

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
        spec.pathParams("first","todos","second",170);

        //2) Set the expected data
        JsonPlaceHolderTestData02 expected = new JsonPlaceHolderTestData02();

        //3) Send PATCH Request
        Response response =
                         given()
                        .spec(spec)
                        .contentType(ContentType.JSON)
                        .body(expected.expectedPatchDataSetUp())
                        .when()
                        .patch("/{first}/{second}");
        response.prettyPrint();

        //4) Assert the output
        response.
                then().
                assertThat().
                statusCode(200).
                body("title", Matchers.equalTo(expected.expectedDataSetUp().get("title")),
                        "userId",Matchers.equalTo(expected.expectedDataSetUp().get("userId")),
                        "completed",Matchers.equalTo(expected.expectedDataSetUp().get("completed")));
    }

}
