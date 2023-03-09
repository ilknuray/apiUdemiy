import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C3_ResponseDegerleriniOtomasyonileTestEtme {
    @Test
    public void test01(){
         /*https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu test ediniz*/
    //set the url
        String url="https://restful-booker.herokuapp.com/booking/10";
        //set the expected data
        //set the request and get the response
        Response response=given().when().get(url);
    }

}
