package tests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

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

        //2.Set the expected data (we will learn it later)

        //3.Send the request
        Response response = given().
                 accept(ContentType.JSON).
                 when().
                 get(url);
        response.prettyPrint();

        //4.Assert the things which are given in the test case
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("code", equalTo("WP100")).
                body("image",equalTo("Wordpress.jpg")).
                body("title.en",equalTo("Wordpress")).
                body("shortDescription.tr",equalTo("Wordpress in nasıl kullanılacağını öğreneceğiz"));
        /*
        If you use body methods more than one, it will work like hard assertion
         */
    }

    //1.Way: Use body()
    @Test
    public void get02(){
        //1.Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";
        //2.Set the expected data (we will learn it later)
        //3.Send the request
        Response response = given().
                accept(ContentType.JSON).
                when().
                get(url);
        //Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("code", equalTo("WP100"),
                        "image", equalTo("wordpress.jpg"),
                        "title.en", equalTo("Wordpress"),
                        "shortDescription.tr",equalTo("Wordpress in nasıl kullanılacağını öğreneceğiz"));
        /*
        If you use body method once, it will work like soft assertion.Because it can not stop execution
        in the middle of the method.
         */
    }

    //2nd Way: Use assert methods
    //Hard Assertion: We have three methods a)assertEquals(expected, actual)
    //                                      b)assertTrue(boolean) ==> pass if condition is true
    //                                      c)assertFalse(boolean)==> pass if condition is false

    @Test
    public void get03(){
        //1.Step: Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

        //2.Step: Set the expected data

        //3. Step: Send the request
        Response response = given().
                accept(ContentType.JSON).
                when().
                get(url);
        response.prettyPrint();

        //4. Step: Assertion:
        assertEquals(200,response.getStatusCode());
        assertEquals("application/json; charset=utf-8",response.getContentType());
        assertTrue(response.asString().contains("WP100"));
        assertTrue(response.asString().contains("wordpress.jpg"));
        assertFalse(response.asString().contains("xxxxxxx"));
        assertTrue(response.asString().contains("Wordpress in nasıl kullanılacağını öğreneceğiz"));
        //Fot this test case using second way is not recommended. Because you re just checking if response body
        //contains a String. You don't check equality like code:"WP100"..etc
    }

    //3rd Way: Use Soft Assertion:
    //         There are three steps in soft assertion
    //          1.Create SoftAssert class object (SoftAssert softAssert = new SoftAssert())
    //          2.Type assertions: assertEquals(actual,expected), assertTrue(boolean), assertFalse(boolean)
    //       !!!3.Use assertAll() ==>If you don't use assertAll() your test will pass but it will not be meaningful

    @Test
    public void get04(){
        //1.Step: Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";
        //2.Step: Set the expected data
        //3. Step: Send the request
        Response response = given().
                accept(ContentType.JSON).
                when().
                get(url);
        response.prettyPrint();
        //4. Step: Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),200,"status code is wrong");//you can add some messages in order to see when your test has failed
        softAssert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
        softAssert.assertTrue(response.asString().contains("WP100"),"NO MATCH");
        softAssert.assertTrue(response.asString().contains("wordpress.jpg"),"NO MATCH");
        softAssert.assertTrue(response.asString().contains("Wordpress in nasıl kullanılacağını öğreneceğiz"),"NO MATCH");
        softAssert.assertAll();
    }
}