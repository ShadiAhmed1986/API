package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class GetRequest02Dt {

    /*
        When I send a GET request to REST API URL
        "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367"
        Then
        HTTP Status Code should be 200
        And Response format should be "application/JSON"
            for the course whose id is "608bb976c9e4a800151ab367"
        And "code" should be "WP100"
        And "image" should be "wordpress.jpg"
        And English "title" should be "Wordpress"
        And Turkish "shortDescription"  should be "Wordpress in nasıl kullanılacağını öğreneceğiz"
   */

    @Test
    public void get01(){

        //1.Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

        //2.Set the expected data

        //3.Send the request
        Response response = given().
                                    accept(ContentType.JSON).
                            when().
                                    get(url);

        //4.Assert the things which are given in the test case

    }

}
