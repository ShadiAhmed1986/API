package get_method;

import base_urls.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.Collections;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
public class GetRequest08dt extends DummyBaseUrl {

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
        //1) Set the Url
        spec.pathParams("first","api","second","v1","third","employees");

        //2) Set the expected data

        //3) Send the request
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        //4) Assert
        response.then().assertThat().statusCode(200);

        JsonPath json = response.jsonPath();

        //1)Print ids greater than 10
        List<Integer> idList = json.getList("data.findAll{(it.id)>10}.id");
        System.out.println(idList);

        //Assert that there are 14 ids greater than 10
        assertEquals(14,idList.size());

        //2) Print all ages less than 30
        List<Integer> listAge = json.getList("data.findAll{(it.id)<30}.employee_age");

        //Assert that maximum age is 23
        //First sort and take the last element
        Collections.sort(listAge);

        //What if ages are String?
        //If ages are String when I use sort method, it will not give me correct order
        //Create an Integer list and by using for each loop take all the Strings and convert them to integer
//        List<Integer> ageListInt = new ArrayList<>();
//        for(String w :listAge ){
//            ageListInt.add(Integer.valueOf(w));
//        }
//        Collections.sort(ageListInt);

        Collections.sort(listAge);

        //convert 23 to Integer
        assertEquals(Integer.valueOf(23), listAge.get(listAge.size()-1));

        //3)Print all employee names whose salaries are greater than 350,000
        List<String> nameList = json.getList("data.findAll{(it.employee_salary)>350.000}.employee_name");
        System.out.println(nameList);

        // Assert that "Charde Marshall" is one of the employees whose salary is greater than 350,000
        assertTrue("The name you searched for is not in the list", nameList.contains("Charde Marshall"));

    }
}