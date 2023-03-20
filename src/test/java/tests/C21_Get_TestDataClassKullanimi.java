package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.internal.mapping.Jackson1Mapper;
import org.json.JSONObject;
import org.junit.Test;
import testDatas.TestDataJsonPlaceHolder;

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
    public void test(){
        //set the url
        specJson.pathParams("pp1","posts","pp2",40);

        //set the expected data
        JSONObject expectedData= TestDataJsonPlaceHolder.responseJsonBodyOlustur(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas \nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");
        System.out.println(expectedData);
    }


}
