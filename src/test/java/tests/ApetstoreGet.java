package tests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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
        //send the request and get the response
        Response response=given().spec(specPetStore).when().get("/{pp1}");
        response.prettyPrint();
        //do assertion
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    }
}
