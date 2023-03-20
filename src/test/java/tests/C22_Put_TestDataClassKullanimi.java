package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request
yolladigimizda donen response’in
status kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header
degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}

     */
    @Test
    public void test(){
        //set the url and request body
        specJson.pathParams("pp1","posts","pp2",70);
        JSONObject requestBody= TestDataJsonPlaceHolder.responseJsonBodyOlustur(10,70,"Ahmet","Merhaba");
        //set the expected data
        JSONObject expectedData=TestDataJsonPlaceHolder.responseJsonBodyOlustur(70,10,"Ahmet","Merhaba");

        //send the request and get the response
        Response response=given().spec(specJson).when().contentType(ContentType.JSON).body(requestBody.toString()).put("{pp1}/{pp2}");

        //do assertion
        assertEquals(TestDataJsonPlaceHolder.basariliStatusCodu,response.statusCode());
        assertEquals(TestDataJsonPlaceHolder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceHolder.Connectionheader,response.header("Connection"));
        JsonPath jsonPath=response.jsonPath();
        assertEquals(expectedData.getInt("userId"),jsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),jsonPath.getInt("id"));

    }
}
