package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import org.junit.Test;

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

    }
}
