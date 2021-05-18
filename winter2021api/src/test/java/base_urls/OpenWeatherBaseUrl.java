package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class OpenWeatherBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri("https://api.openweathermap.org").build();
    }
}
