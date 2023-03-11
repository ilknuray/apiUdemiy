package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestapi extends JsonPlaceHolderBaseUrl {
    @Test
    public void test(){
        /*
        1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
edin
2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
donen response’un status code’unun 200 oldugunu ve “title” degerinin
“optio dolor molestias sit” oldugunu test edin
3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
null oldugunu test edin
         */
        //set the url and request body
        specJson.pathParam("pp1","posts");
        //set the expected body

        //send the tequest and get the response

        Response response=given().when().spec(specJson).get("/{pp1}");
        //do assertion
        response.then().assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));
    }


}
