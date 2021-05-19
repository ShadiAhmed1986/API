package get_method;

import base_urls.OpenWeatherBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import test_data.OpenWeatherMapTestData;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
public class ReviewGetRequest10Sunday extends OpenWeatherBaseUrl {

    /*
        When
	 		I send GET Request to the Url https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0
	 	Then
	 		Status code is 200
	 		And Response body is like {
    "coord": {
        "lon": -0.1257,
        "lat": 51.5085
    },
    "weather": [
        {
            "id": 801,
            "main": "Clouds",
            "description": "few clouds",
            "icon": "02d"
        }
    ],
    "base": "stations",
    "main": {
        "temp": 288,
        "feels_like": 287.29,
        "temp_min": 285.68,
        "temp_max": 289.82,
        "pressure": 1013,
        "humidity": 67
    },
    "visibility": 9000,
    "wind": {
        "speed": 0.45,
        "deg": 269,
        "gust": 3.13
    },
    "clouds": {
        "all": 20
    },
    "dt": 1621337081,
    "sys": {
        "type": 2,
        "id": 2019646,
        "country": "GB",
        "sunrise": 1621310658,
        "sunset": 1621367389
    },
    "timezone": 3600,
    "id": 2643743,
    "name": "London",
    "cod": 200
}
     */

    @Test
    public void get01(){
        //1) Step set the URL
        spec.pathParams("first","data","second",2.5,"third","weather").
                queryParams("q","London","appid","f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");

        //2) Set the expected data
        OpenWeatherMapTestData expected = new OpenWeatherMapTestData();

        //3) Send the request
        Response response =
                given().
                        spec(spec).
                        contentType(ContentType.JSON).
                        when().
                        get("/{first}/{second}/{third}");
        response.prettyPrint();

        //4) Assert
        JsonPath json = response.jsonPath();

        assertEquals(200,response.statusCode());
        assertEquals(expected.coordSetUp().get("lon"),(Float) json.getFloat("coord.lon"));
        assertEquals(expected.coordSetUp().get("lat"),(Float)json.getFloat("coord.lat"));
        assertEquals(expected.weatherSetUp().get("main"),json.getString("weather[0].main"));
    }
}
