package tests;

import baseUrl.BaseUrlPetStore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.TestDataPetStore;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PetStoreGet extends BaseUrlPetStore {
    /*
    {
  "id": 0,
  "petId": 0,
  "quantity": 0,
  "shipDate": "2023-03-23T20:28:24.296Z",
  "status": "placed",
  "complete": true
}
https://petstore.swagger.io/v2/store/order/1
     */
    @Test
    public void test() {
        //set the url and set the request body

        specPetStore.pathParams("pp1", "store", "pp2", "order", "pp3", 1);

        //set the expected body

        //send the request and get the response

        Response response = given().spec(specPetStore).when().get("/{pp1}/{pp2}/{pp3}");
        //response.prettyPrint();

        //do assertion

        JsonPath responseJsonpath = response.jsonPath();
        JSONObject expectedData = TestDataPetStore.expectedData(0, 0, 0, "2023-03-23T20:28:24.296Z", "placed", true);

        assertEquals(TestDataPetStore.basariliKodu, response.statusCode());
        assertEquals(expectedData.getInt("id"), responseJsonpath.getInt("id"));
        assertEquals(expectedData.getInt("petId"), responseJsonpath.getInt("petId"));
        assertEquals(expectedData.getString("status"), responseJsonpath.getString("status"));
        assertEquals(expectedData.getBoolean("complete"), responseJsonpath.getBoolean("complete"));


    }
}
