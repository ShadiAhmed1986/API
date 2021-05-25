package get_method;

import base_urls.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequestExercise02 extends DummyBaseUrl {

     /*
     When
             I send GET Request to URL http://dummy.restapiexample.com/api/v1/employees
         Then
             Status code is 200
             1)Print all ids greater than 10 on the console
               Assert that there are 14 ids greater than 10
             2)Print all ages less than 30 on the console
               Assert that maximum age is 23
             3)Print all employee names whose salaries are greater than 350,000
               Assert that "Charde Marshall" is one of the employees whose salary is greater than 350,000
     */

    @Test
    public void get01(){
        //Set the URL
        spec.pathParams("first","api","second","v1","third","employees");

        //Set the expected data

        //Send request
        Response response =
                        given()
                        .spec(spec)
                        .accept(ContentType.JSON)
                        .when()
                        .get("/{first}/{second}/{third}");
        response.prettyPrint();

        //Assert

        //Status code is 200
        response.then().assertThat().statusCode(200);


        JsonPath jsonPath = response.jsonPath();

        //2) Print all ages less than 30
        List<Integer> listAge = jsonPath.getList("data.findAll{(it.id)<30}.employee_age");


    }
}
