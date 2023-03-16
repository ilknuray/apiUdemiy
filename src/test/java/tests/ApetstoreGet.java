package tests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApetstoreGet extends PetStoreBaseUrl {
    /*
    {
  "id": 1,
  "category": {
    "id": 1,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 1,
      "name": "string"
    }
  ],
  "status": "available"
}
     */
    @Test
    public void test(){
        //set the url
        specPetStore.pathParam("pp1","1");
        //set the expected data
        JSONObject expectedData=new JSONObject();
        JSONObject category=new JSONObject();
        category.put("id", 1);
        category.put("name", "string");
        JSONArray tags=new JSONArray();
        JSONObject tagsId=new JSONObject();
        tagsId.put("id", 1);
        tagsId.put("name", "string");
        tags.put(tagsId);
        JSONArray photo=new JSONArray();
        photo.put("string");

        expectedData.put("id", 1);
        expectedData.put("category",category);
        expectedData.put("name", "doggie");
        expectedData.put("photoUrls",photo);
        expectedData.put("tags",tags);
        expectedData.put("status", "available");
        //System.out.println("expected data : "+expectedData);


        //send the request and get the response
        Response response=given().spec(specPetStore).when().get("/{pp1}");
        response.prettyPrint();
        //do assertion
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(expectedData.get("id"),jsonPath.get("id"));
    }
}
