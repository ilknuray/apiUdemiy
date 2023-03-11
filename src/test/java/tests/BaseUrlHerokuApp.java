package tests;

import baseUrl.RestFullHerokuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BaseUrlHerokuApp extends RestFullHerokuBaseUrl {
    /*
    2- https://restful-booker.herokuapp.com/booking
endpointine yandaki body’ye sahip bir POST request
gonderdigimizde donen response’un status code’unun
200 oldugunu ve “firstname” degerinin “Ahmet”
oldugunu test edin

                        {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                        "checkin" : "2021-06-01",
                        "checkout" : "2021-06-10"
                        },
                        "additionalneeds" : "wi-fi"
                        }

     */
    @Test
    public void test() {
        specHeroku.pathParam("pp1", "booking");

        JSONObject requestBody = new JSONObject();
        JSONObject booking=new JSONObject();
        booking.put("checkin" , "2021-06-01");
        booking.put("checkout" , "2021-06-10");
        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("additionalneeds" , "wi-fi");
        requestBody.put("bookingdates",booking);


        //set the expected data

        JSONObject expectedData=new JSONObject();
        expectedData.put("firstname","Ahmet");

        //send the request and get the response

        Response response=given().contentType(ContentType.JSON).spec(specHeroku).when().body(requestBody.toString()).post("/{pp1}");

        //do assertion
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(jsonPath.get("firstname"),expectedData.get("firstname"));
        response.then().assertThat().statusCode(200);
    }
}
