package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestFullHerokuBaseUrl {

   protected RequestSpecification specHeroku;

    public void setUp(){
        specHeroku=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
