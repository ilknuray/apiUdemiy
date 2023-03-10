package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification specJson;

    @Before
    public void setup(){
        specJson=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }
}
