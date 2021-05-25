package get_method;

import base_urls.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class GetRequest07 extends DummyBaseUrl {

    /*
        Use JsonPath Class and Soft Assertion to do;
        When
            I send Get Request to http://dummy.restapiexample.com/api/v1/employees
        Then
            The Status code is 200
            And The name of 3rd employee is "Ashton Cox"
            And The Salary of 6th employee is 372000
            And The age of the last employee is 23
            And 21, 23, 61 are among the ages
 */

    @Test
    public void get01(){
        //Set the URL
        spec.pathParam("employeesName","employees");

        //Set the expected data

        //Send the request
        Response response =
                         given()
                        .spec(spec)
                        .when()
                        .get("/{employeesName}");
        response.prettyPrint();

        //Assert
        JsonPath json = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(),200);

        //And The name of 3rd employee is "Ashton Cox"
        softAssert.assertEquals(json.getString("data[2].employee_name"),"Ashton Cox","name does not match");
        softAssert.assertEquals(json.getInt("data[5].employee_salary"),372000,"salary does not match");
        softAssert.assertEquals(json.getInt("data[-1].employee_age"),23,"age doesn't match");

        //How to assert multiple data by using JsonPath class
        // And 21, 23, 61 are among the ages

        //Create a list and put the test data into that list
        List<Integer> ageList = new ArrayList<>();
        ageList.add(21);
        ageList.add(23);
        ageList.add(61);

        //Use containAll() method
        softAssert.assertTrue(json.getList("data.employee_age").containsAll(ageList),"at least one of the ages does not exist");

        softAssert.assertAll();
    }
}
