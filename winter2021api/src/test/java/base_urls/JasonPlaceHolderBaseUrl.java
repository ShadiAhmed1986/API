package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JasonPlaceHolderBaseUrl {
    //1) Create RequestSpecification object
    protected RequestSpecification spec;

    //If you use @Before annotation before a method,
    // it means that the method will be executed before every test method
    @Before
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }
}
