package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen
response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */

    @Test
    public void test(){

        //set the url
        specJson.pathParams("pp1","posts","pp2",22);

        //set the expected data
        JSONObject expectedDta= TestDataJsonPlaceHolder.expectedData22();
        //send the request and get the response
        Response response=given().spec(specJson).when().get("/{pp1}/{pp2}");
        JsonPath jsonPath=response.jsonPath();

        //do assertion
        assertEquals(TestDataJsonPlaceHolder.basariliStatusCodu,response.statusCode());
        assertEquals(expectedDta.getInt("userId"),jsonPath.getInt("userId"));
        assertEquals(expectedDta.getInt("id"),jsonPath.getInt("id"));
        assertEquals(expectedDta.getString("title"),jsonPath.getString("title"));
        assertEquals(expectedDta.getString("body"),jsonPath.getString("body"));
    }
}
