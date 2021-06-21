package get_method;

import base_urls.OpenWeatherBaseUrl;
import org.junit.Test;

public class PracticeGetRequest01 extends OpenWeatherBaseUrl {

    /*When
   I send GET Request to the Url https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0
Then
   Status code is 200
   And Response body is like {
                         "coord": {
                             "lon": -0.13,
                             "lat": 51.51
                         },
                         "weather": [
                             {
                                 "id": 801,
                                 "main": "Clouds",
                                 "description": "few clouds",
                                 "icon": "02n"
                             }
                         ],
                         "base": "stations",
                         "main": {
                             "temp": 284.57,
                             "feels_like": 280.6,
                             "temp_min": 283.71,
                             "temp_max": 285.37,
                             "pressure": 1007,
                             "humidity": 81
                         },
                         "visibility": 10000,
                         "wind": {
                             "speed": 5.1,
                             "deg": 160
                         },
                         "clouds": {
                             "all": 20
                         },
                         "dt": 1608329611,
                         "sys": {
                             "type": 1,
                             "id": 1414,
                             "country": "GB",
                             "sunrise": 1608278540,
                             "sunset": 1608306738
                         },
                         "timezone": 0,
                         "id": 2643743,
                         "name": "London",
                         "cod": 200
                     }*/


    @Test
    public void get01(){
        //Set the Url
        spec.pathParams("first","data","second",2.5,"third","weather").queryParams("q","London","appid","f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");


    }
}
