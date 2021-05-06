package tests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
public class GetRequest01Dt {
    /*
    ==Gherkin Language===
    If you use, "Given", "When", "Then", "And" to create test scenarios, it means you re using Gherkin Language
    "Given" : It declares prerequisites
    "When" : It defines actions which user will perform
    "Then" : We talk about outcomes
    "And" : In any part if you have multiple steps use "And" between them
     */
    /*
       When
           I send a GET Request to the URL https://api-techproed-test.herokuapp.com/courses
       Then
           HTTP Status Code should be 200
       And
           Content Type should be JSON
       And
           Status Line should be HTTP/1.1 200 OK
   */
    @Test
    public void get01(){
        //We will follow these four steps for each test in API

        //1st Step: Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses";

        //2nd Step: Set the expected data (we will learn it later)

        //3rd Step : Send the request (Like clicking on Send button in the Postman)
        Response response = given().
                accept(ContentType.JSON).//"application/json" and ContentType.JSON are same
                when().                        //it is not must to use accept() but sometimes it solves the problems
                get(url);
        //to see response body on the console use prettyPrint()
        response.prettyPrint();

        //4th Step : Assert the things which are given in the test case
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

        //Note: If execution stops after first error, it is called "HARD ASSERTION"
        //      If execution doesn't stop for any error it is called "SOFT ASSERTION"
        //      You can take separate reports for each error in soft assertion
        //How to print status_code, content type, statusline, time in the console

        System.out.println(response.getStatusLine());//HTTP/1.1 200 OK
        System.out.println(response.statusCode());//200
        System.out.println(response.getContentType());
        System.out.println(response.getTime());
        System.out.println(response.getHeaders());
    }
}