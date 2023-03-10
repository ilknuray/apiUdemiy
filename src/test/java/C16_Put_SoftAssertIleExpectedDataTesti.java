import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {
    /*http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin
        {
        "status": "success",
        "data": {
        "name": “Ahmet",
        "salary": "1230",
        "age": "44",
        "id": 40
        }
        }
                                                    { "status": "success",
                                            "data": {
                                            "status": "success",
                                            "data": {
                                            "name": “Ahmet",
                                            "salary": "1230",
                                            "age": "44",
                                            "id": 40 }
                                            },
                                            "message": "Successfully! Record has been updated."}


     */
    @Test
    public void test() {
        //set the url and request body
        String url = "http://dummy.restapiexample.com/api/v1/update/21";
        JSONObject requestBody = new JSONObject();
        JSONObject data = new JSONObject();
        data.put("name", "Ahmet");
        data.put("salary", "1230");
        data.put("age", "44");
        data.put("id", 40);
        requestBody.put("status", "success");
        requestBody.put("data", data);

        //set the expected data
        JSONObject expectedData = new JSONObject();
        JSONObject data1 = new JSONObject();

        expectedData.put("message", "Successfully! Record has been updated.");
        expectedData.put("status", "success");
        expectedData.put("data", requestBody);

        //send the request and get the response
        Response response = given().contentType(ContentType.JSON).when().body(requestBody.toString()).put(url);

        //do assertion

        SoftAssert softAssert = new SoftAssert();
        JsonPath jsonPath = response.jsonPath();

        softAssert.assertEquals(jsonPath.get("status"), expectedData.get("status"));
        softAssert.assertEquals(jsonPath.get("message"), expectedData.get("message"));
        softAssert.assertEquals(jsonPath.get("data.status"), expectedData.getJSONObject("data").get("status"));
        softAssert.assertEquals(jsonPath.get("data.data.name"), expectedData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(jsonPath.get("data.data.salary"), expectedData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(jsonPath.get("data.data.age"), expectedData.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(jsonPath.get("data.data.id"), expectedData.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertAll();


    }
}
