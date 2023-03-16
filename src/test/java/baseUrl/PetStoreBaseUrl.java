package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PetStoreBaseUrl {
    protected RequestSpecification specPetStore;

    @Before
    public void setUp(){
        specPetStore=new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet").build();

    }
}
