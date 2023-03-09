import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C8_Post_ResponseBodyTesti {
    /*
                        https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
                    gonderdigimizde
                    {
                    "title":"API",
                    "body":"API ogrenmek ne guzel",
                    "userId":10,
                    }
                    donen Response’un,
                    status code’unun 201,
                    ve content type’inin application/json
                    ve Response Body'sindeki,
                    "title"'in "API" oldugunu
                    "userId" degerinin 100'den kucuk oldugunu
                    "body" nin "API" kelimesi icerdigini
                    test edin.
     */
    @Test
    public void test(){
        //set the url and request body
        String url="https://jsonplaceholder.typicode.com/posts";
        JSONObject obj=new JSONObject();
        obj.put("title","API");
        obj.put("body","API ogrenmek ne guzel");
        obj.put("userId",10);

        //set the expected data

        //send the request and get the response

        Response response=given().contentType(ContentType.JSON)
                .when().body(obj.toString()).post(url);

        //do assertion

        response.then().assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("userId",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));

    }
}
