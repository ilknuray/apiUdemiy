import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C11_JsonPathleBodyTesti {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde
                                        {
                                        "firstname" : "Ahmet",
                                        "lastname" : “Bulut",
                                        "totalprice" : 500,
                                        "depositpaid" : false,
                                        "bookingdates" : {
                                        "checkin" : "2023-01-10",
                                        "checkout" : "2023-01-20"
                                        },
                                        "additionalneeds" : "wi-fi"
                                        }

                                                                                donen Response’un,
                                                                                status code’unun 200,
                                                                                ve content type’inin application-json,
                                                                                ve response body’sindeki
                                                                                "firstname“in,"Ahmet",
                                                                                ve "lastname“in, "Bulut",
                                                                                ve "totalprice“in,500,
                                                                                ve "depositpaid“in,false,
                                                                                ve "checkin" tarihinin 2023-01-10
                                                                                ve "checkout" tarihinin 2023-01-20
                                                                                ve "additionalneeds“in,"wi-fi"
                                                                                oldugunu test edin
     */
    @Test
    public void test(){
        //set the url and request body

        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject bilgiler=new JSONObject();
        JSONObject tarihler=new JSONObject();
        tarihler.put("checkin" , "2023-01-10");tarihler.put("checkout" , "2023-01-20");

        bilgiler.put("bookingdates",tarihler);
        bilgiler.put("firstname","Ahmet");
        bilgiler.put("lastname","Bulut");
        bilgiler.put("totalprice" , 500);
        bilgiler.put("depositpaid" , false);

        //set the expected data

        //send the request and get the response

        Response respense=given().contentType(ContentType.JSON).when().body(bilgiler.toString()).post(url);

        //Do assertion

        respense.then().assertThat()

                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname", equalTo("Ahmet"),
                        "booking.lastname",equalTo("Bulut"),
                        "booking.bookingdates.checkin",equalTo("2023-01-10"));
    }
}
