package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.internal.mapping.Jackson1Mapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/40 url'ine bir GET request yolladigimizda donen
response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
ediniz
Response body :
{
"userId": 4,
"id": 40,
"title": "enim quo cumque",
"body": "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia
quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
}
     */

    @Test
    public void test() {
        //set the url
        specJson.pathParams("pp1", "posts", "pp2", 40);

        //set the expected data
        JSONObject expectedData = TestDataJsonPlaceHolder.responseJsonBodyOlustur(4, 40, "enim quo cumque", "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas \nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");
        //send the request and get the response
        Response response = given().spec(specJson).when().get("{pp1}/{pp2}");

        //do assertion
        JsonPath jsonPath=response.jsonPath();
        assertEquals(TestDataJsonPlaceHolder.basariliStatusCodu,response.statusCode());
        assertEquals(expectedData.getInt("userId"),jsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),jsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"),jsonPath.getString("title"));
        //assertEquals(expectedData.getString("body"),jsonPath.getString("body"));


    }


}
