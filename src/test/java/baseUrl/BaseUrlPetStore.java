package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlPetStore {

    protected RequestSpecification specPetStore;

    @Before
    public void setup(){
        specPetStore=new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();
    }

}
