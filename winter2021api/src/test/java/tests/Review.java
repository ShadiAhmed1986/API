package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class Review {

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
    public void Review(){
        //1.Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

        //2.Set the expected data

        //3.Send the request
        Response response = given().
                            accept(ContentType.JSON).
                            when().
                            get(url);
        response.prettyPrint();

        //4.Assert
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("code", Matchers.equalTo("WP100")).
                body("image",Matchers.equalTo("wordpress.jpg")).
                body("title.en",Matchers.equalTo("Wordpress")).
                body("shortDescription.tr",Matchers.equalTo("Wordpress in nasıl kullanılacağını öğreneceğiz"));
    }

    @Test
    public void Review2way(){
        //1.Set the URL
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

        //2.Set the expected data

        //3.Send the request
        Response response = given().
                            accept(ContentType.JSON).
                            when().
                            get(url);

        //4.Assert
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("code", equalTo("WP100"),
                        "image",equalTo("wordpress.jpg"),
                        "title.en",equalTo("Wordpress"),
                        "shortDescription.tr",equalTo("Wordpress in nasıl kullanılacağını öğreneceğiz"));

    }

    @Test
    public void Review3way(){
        //1.Set the URL
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

        //2.Set the expected data

        //3.Send the request
        Response response = given().accept(ContentType.JSON).when().get(url);

        //Assert
        assertEquals(200, response.statusCode());
        assertEquals("application/json; charset=utf-8",response.contentType());
        assertTrue(response.asString().contains("WP100"));
        assertTrue(response.asString().contains("wordpress.jpg"));
        assertTrue(response.asString().contains("Wordpress"));
        assertTrue(response.asString().contains("Wordpress in nasıl kullanılacağını öğreneceğiz"));
    }

    @Test
    public void Review4way(){
        //1.Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

        //2.Set the expected data

        //3.Send the request
        Response response = given().accept(ContentType.JSON).when().get(url);

        //4.Assert
        SoftAssert SoftAssert = new SoftAssert();
        SoftAssert.assertEquals(response.statusCode(),200);
        SoftAssert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        SoftAssert.assertTrue(response.asString().contains("WP100"),"message if error");
        SoftAssert.assertTrue(response.asString().contains("wordpress.jpg"), "message if doesnt contain");
        SoftAssert.assertTrue(response.asString().contains("Wordpress"));
        SoftAssert.assertTrue(response.asString().contains("Wordpress in nasıl kullanılacağını öğreneceğiz"));

        SoftAssert.assertAll();
    }

}
