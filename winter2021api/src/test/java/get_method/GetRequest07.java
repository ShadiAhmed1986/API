package get_method;

import base_urls.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

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
        spec.pathParam("employeesName","employees");

        Response response = given().spec(spec).when().get("/{employeesName}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(),200);

        //And The name of 3rd employee is "Ashton Cox"
        softAssert.assertEquals(json.getString("data[2].employee_name"),"Ashton Cox");
        softAssert.assertEquals(json.getInt("data[5].employee_salary"),372000);
    }
}
