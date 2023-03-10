import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_Get_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
                yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
                Response body :
                {
                "userId": 3,
                "id": 22,
                "title": "dolor sint quo a velit explicabo quia nam",
                "body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
                um mollitia molestiae aut atque rem suscipitnam impedit esse"
}
     */
    @Test
    public void test(){
        //set the url and request body
        String url="https://jsonplaceholder.typicode.com/posts/22";
        //=>request bodyi olusturmayacagim cunku get methodunda bir sey yollamiyorum sadece donus aliyorum

        //set the expected body
        JSONObject expectedData=new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear um mollitia molestiae aut atque rem suscipitnam impedit esse");

        //send the request and get the response
        Response response=given().when().get(url);

        //do assertion
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(expectedData.get("userId"),jsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.get("id"),jsonPath.getInt("id"));
        Assert.assertEquals(expectedData.get("title"),jsonPath.getString("title"));


        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);

    }
}
