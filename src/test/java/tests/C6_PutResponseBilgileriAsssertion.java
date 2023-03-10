package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C6_PutResponseBilgileriAsssertion {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir
PUT request gonderdigimizde
                    {
                    "title": "Ahmet",
                    "body": "Merhaba",
                    "userId": 10,
                    "id": 70
                    }
                    donen Response’un,
                    status code’unun 200,
                    ve content type’inin application/json; charset=utf-8,
                    ve Server isimli Header’in degerinin cloudflare,
                    ve status Line’in HTTP/1.1 200 OK
     */
    @Test
    public void test(){
        //set the url and requet body
        String url="https://jsonplaceholder.typicode.com/posts/70";
        JSONObject obj=new JSONObject();
        obj.put("title","Ahmet");
        obj.put("body", "Merhaba");
        obj.put("userId",10);
        obj.put("id",70);

        //set the expected data

        //send the request And get the response
        Response response =given().contentType(ContentType.JSON).when().body(obj.toString()).put(url);
        response.prettyPrint();

        //Do assertion

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).header("Server","cloudflare").statusLine("HTTP/1.1 200 OK");
    }
}
