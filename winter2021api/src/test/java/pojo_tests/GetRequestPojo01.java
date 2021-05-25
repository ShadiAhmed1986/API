package pojo_tests;

import base_urls.TechProBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.CoursePojo;
import pojos.LongDescriptionPojo;
import pojos.ShortDescriptionPojo;
import pojos.TitlePojo;
import utilities.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;


public class GetRequestPojo01 extends TechProBaseUrl {

    /*
    When I sen GET request to https://api-techproed-test.herokuapp.com/courses/1
    Status Code should be 200 and response body should be like:
    {
    "_id": 1,
    "code": "",
    "title": {
        "en": "HTML5",
        "tr": ""
    },
    "shortDescription": {
        "en": "Learn the anatomy of HTML syntax to structure your websites. Understand the HTML boilerplate and HTML doctypes. How to structure text in HTML. How to structure HTML lists to create unordered and ordered lists. How to insert images using HTML.",
        "tr": ""
    },
    "longDescription": {
        "en": "Learn the anatomy of HTML syntax to structure your websites. Understand the HTML boilerplate and HTML doctypes. How to structure text in HTML. How to structure HTML lists to create unordered and ordered lists. How to insert images using HTML.",
        "tr": ""
    },
    "image": "html5.jpg",
    "slug": "html5",
    "__v": 0
}
     */

    @Test
    public void get01(){
        //1) Set the URL
        spec.pathParam("first",1);

        //2) Set the expected data
        TitlePojo titlePojo = new TitlePojo("HTML5","");

        ShortDescriptionPojo shortDescriptionPojo = new ShortDescriptionPojo("Learn the anatomy of HTML syntax to structure your websites. Understand the HTML boilerplate and HTML doctypes. " +
                "How to structure text in HTML. How to structure HTML lists to create unordered and ordered lists. How to insert images using HTML.","");

        LongDescriptionPojo longDescriptionPojo = new LongDescriptionPojo("Learn the anatomy of HTML syntax to structure your websites. Understand the HTML boilerplate and HTML doctypes. " +
                "How to structure text in HTML. How to structure HTML lists to create unordered and ordered lists. How to insert images using HTML.","");

        CoursePojo expectedPojo = new CoursePojo(titlePojo,shortDescriptionPojo,longDescriptionPojo,"html5.jpg","html5");

        //3) Send the request
        Response response =
                given().
                        spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4) Assertion

        //Use GSON
        CoursePojo actualPojo = response.as(CoursePojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedPojo.getTitle().getEn(),actualPojo.getTitle().getEn());
        assertEquals(expectedPojo.getShortDescription().getEn(),actualPojo.getShortDescription().getEn());
        assertEquals(expectedPojo.getShortDescription().getTr(),actualPojo.getShortDescription().getTr());
        assertEquals(expectedPojo.getLongDescription().getEn(),actualPojo.getLongDescription().getEn());
        assertEquals(expectedPojo.getLongDescription().getTr(),actualPojo.getLongDescription().getTr());
        assertEquals(expectedPojo.getImage(),actualPojo.getImage());
        assertEquals(expectedPojo.getSlug(),actualPojo.getSlug());

        //Use ObjectMapper for de-serialization
        CoursePojo actualPojo2 = JsonUtil.convertJsonToJava(response.asString(),CoursePojo.class);
        assertEquals(expectedPojo.getTitle().getEn(),actualPojo2.getTitle().getEn());
        assertEquals(expectedPojo.getShortDescription().getEn(),actualPojo2.getShortDescription().getEn());
        assertEquals(expectedPojo.getShortDescription().getTr(),actualPojo2.getShortDescription().getTr());
        assertEquals(expectedPojo.getLongDescription().getEn(),actualPojo2.getLongDescription().getEn());
        assertEquals(expectedPojo.getLongDescription().getTr(),actualPojo2.getLongDescription().getTr());
        assertEquals(expectedPojo.getImage(),actualPojo2.getImage());
        assertEquals(expectedPojo.getSlug(),actualPojo2.getSlug());

    }
}
