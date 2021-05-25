package get_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequestExercise extends JsonPlaceHolderBaseUrl {

    /*
        When
             I send GET Request to URL https://jsonplaceholder.typicode.com/todos
        Then
             Status code is 200
        1)Print all ids greater than 190 on the console
             Assert that there are 10 ids greater than 190
        2)Print all userIds less than 5 on the console
              Assert that maximum userId less than 5 is 4
        3)Print all titles whose ids are less than 5
             Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */

    @Test
    public void get01(){
        //Set the URL
        spec.pathParam("first","todos");

        //Set the expected data

        //Send request
        Response response =
                        given()
                        .spec(spec).accept(ContentType.JSON)
                        .when()
                        .get("/{first}");
        //response.prettyPrint();

        //Assert
        //Status code is 200
        JsonPath jsonPath = response.jsonPath();
        assertEquals(200, response.statusCode());

        //Print all ids greater than 190 on the console
        List<Integer> idList = jsonPath.getList("findAll{it.id > 190}.id");
        //System.out.println(idList);

        //Assert that there are 10 ids greater than 190
        assertTrue(idList.size()==10);

        //Print all userIds less than 5 on the console
        List<Integer> userid = jsonPath.getList("findAll{it.userId<5}.userId");
        //System.out.println(userid);

        //Assert that maximum userId less than 5 is 4
        Collections.sort(userid);
        assertEquals((Integer) 4,userid.get(userid.size()-1));

        //Print all titles whose ids are less than 5
        List<String> titleList = jsonPath.getList("findAll{it.id < 5}.title");
        System.out.println(titleList);

        //Assert that "delectus aut autem" is one of the titles whose id is less than 5
        //assertTrue(titleList.contains("delectus aut autem"));
        boolean result = titleList.stream().anyMatch(t->t.equals("delectus aut autem"));
        assertTrue(result);


    }
}
