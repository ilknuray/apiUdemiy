package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
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
                                {
                                "bookingid": 24,
                                "booking": {
                                "firstname": "Ahmet",
                                "lastname": "Bulut",
                                "totalprice": 500,
                                "depositpaid": false,
                                "bookingdates": {
                                "checkin": "2021-06-01",
                                "checkout": "2021-06-10"
                                },
                                "additionalneeds": "wi-fi"
                                }
}

     */
    @Test
    public void test() {
        //set the url and request body
        String url = " https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody = new JSONObject();
        JSONObject rezTarih = new JSONObject();
        rezTarih.put("checkin", "2021-06-01");
        rezTarih.put("checkout", "2021-06-10");
        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("additionalneeds", "wi-fi");
        requestBody.put("bookingsdates", rezTarih);
        //set the expected data
        JSONObject expectedData = new JSONObject();

        expectedData.put("bookingid", 6353);

        expectedData.put("booking", requestBody);


        //send the request and get the response
        Response response = given().contentType(ContentType.JSON).when().body(requestBody.toString()).post(url);
        //do assertion
        response.prettyPrint();
      /*  JsonPath jsonPath = response.jsonPath();
        assertEquals(expectedData.getJSONObject("booking").get("firstname"), jsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"), jsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"), jsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"), jsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"), jsonPath.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"), jsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"), jsonPath.get("booking.bookingdates.checkout"));

       */
    }
}
