package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_DeleteBaseUrl extends JsonPlaceHolderBaseUrl {
    /*3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
null oldugunu test edin

     */
    @Test
    public void test(){
        //set the url and response body
        specJson.pathParams("pp1","posts","pp2",50);
        //set the expected data

        //send the request and get the response
        Response response=given().spec(specJson).when().delete("/{pp1}/{pp2}");

        //do assertion
        response.then().assertThat().contentType(ContentType.JSON).body("title", Matchers.nullValue());
    }
}
