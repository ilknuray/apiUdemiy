package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Get_SoftAssertIleExpectedDataTesti {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un asagidaki gibi oldugunu test edin
                                    {
                                    "status": "success",
                                    "data": {
                                    "id": 3,
                                    "employee_name": "Ashton Cox",
                                    "employee_salary": 86000,
                                    "employee_age": 66,
                                    "profile_image": ""
                                    },
                                    "message": "Successfully! Record has been fetched."
                                    }

     */
    @Test
    public void test(){
        //set the url and request body
        String url="http://dummy.restapiexample.com/api/v1/employee/3";
         //set the expected data
        JSONObject expectedData=new JSONObject();

        JSONObject data=new JSONObject();
        data.put("id", 3);
        data.put("employee_name", "Ashton Cox");
        data.put("employee_salary", 86000);
        data.put("employee_age", 66);
        data.put("profile_image", "");
        expectedData.put("data",data);
        expectedData.put("message", "Successfully! Record has been fetched.");
        expectedData.put("status", "success");

        //send the request and get the response

        Response response=given().when().get(url);

        //do assertion
        JsonPath jsonPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();

       // softAssert.assertEquals(jsonPath.get("data.id"),expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(jsonPath.get("data.employee_name"),expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(jsonPath.get("data.employee_salary"),expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(jsonPath.get("data.employee_age"),expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(jsonPath.get("data.profile_image"),expectedData.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(jsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(jsonPath.get("message"),expectedData.get("message"));
        softAssert.assertAll();



    }
}
