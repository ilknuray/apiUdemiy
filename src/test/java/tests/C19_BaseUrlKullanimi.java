package tests;

import baseUrl.RestFullHerokuBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlKullanimi extends RestFullHerokuBaseUrl {
    /*
    1- https://restful-booker.herokuapp.com/booking endpointine bir GET request gonderdigimizde
donen response’un status code’unun 200 oldugunu ve Response’ta 12 booking oldugunu test
edin
     */
   @Test
   public void test(){
        //set the url
        specHeroku.pathParam("pp1","booking");
        //set the expected data
        //send request and get the response

        Response response=given().spec(specHeroku).when().get("/{pp1}");

        //do assertion
        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getList("bookingid").size());
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(2000));
    }
}
