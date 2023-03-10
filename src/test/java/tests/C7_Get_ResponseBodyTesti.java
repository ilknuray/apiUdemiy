package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C7_Get_ResponseBodyTesti {
    /*
    https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
                    donen Response’in
                    status code'unun 200,
                    ve content type'inin Aplication.JSON,
                    ve response body'sinde bulunan userId'nin 5,
                    ve response body'sinde bulunan title'in "optio dolor molestias sit"
                    oldugunu test edin.
     */

    @Test
    public void test(){
        //set the url and set the request body

        String url="https://jsonplaceholder.typicode.com/posts/44";

        //set the expected data

        //send request ant get the response

        Response response=given().when().get(url);

        //do assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }
}
