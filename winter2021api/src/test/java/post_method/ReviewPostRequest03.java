package post_method;

import base_urls.AgroMonitoringBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import test_data.ReviewAgroMonitoringTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ReviewPostRequest03 extends AgroMonitoringBaseUrl {

    /*
        When
		 I send POST Request to the Url "http://api.agromonitoring.com/agro/1.0/polygons?appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0"
		 with the Request Body like  {
										   "name":"Polygon Sample",
										   "geo_json":{
										      "type":"Feature",
										      "properties":{},
										      "geometry":{
										         "type":"Polygon",
										         "coordinates":[
										            [
										               [-121.1958,37.6683],
										               [-121.1779,37.6687],
										               [-121.1773,37.6792],
										               [-121.1958,37.6792],
										               [-121.1958,37.6683]
										            ]
										         ]
										      }
										   }
										}
	Then
		Assert Status Code (201)
		And Response Body should be like {
										    "id": "5fd8c383714b523b2ce1f154",
										    "geo_json": {
										        "geometry": {
										            "coordinates": [
										                [
										                    [
										                        -121.1958,
										                        37.6683
										                    ],
										                    [
										                        -121.1779,
										                        37.6687
										                    ],
										                    [
										                        -121.1773,
										                        37.6792
										                    ],
										                    [
										                        -121.1958,
										                        37.6792
										                    ],
										                    [
										                        -121.1958,
										                        37.6683
										                    ]
										                ]
										            ],
										            "type": "Polygon"
										        },
										        "type": "Feature",
										        "properties": {

										        }
										    },
										    "name": "Polygon Sample",
										    "center": [
										        -121.1867,
										        37.67385
										    ],
										    "area": 190.9484,
										    "user_id": "5fd8c02a3da20c000759e0f8",
										    "created_at": 1608041347
										}
     */

    @Test
    public void post03(){
        //1) Set the URL
        spec.pathParams("first","agro",
                "second",1.0,"third","polygons").
                queryParam("appid","f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");

        //2) Set the expected data
        ReviewAgroMonitoringTestData expectedData = new ReviewAgroMonitoringTestData();

        //3) Send post request
        Response response =
                given().
                        spec(spec).
                        contentType(ContentType.JSON).
                        body(expectedData.expectedDataSetUp()).
                        when().
                        post("/{first}/{second}/{third}");
        response.prettyPrint();

        //4) Assert
       response.
               then().
               assertThat().
               statusCode(201).
               body("geo_json.type", equalTo(expectedData.geoJsonSetUp().get("type")));
        System.out.println(expectedData.geoJsonSetUp().get("type"));
    }
}
