import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C2_GetRequest_ResponseBilgilerininTesti {
    @Test
    public void get02(){
        /*https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz*/

        //set the url
        String url="https://restful-booker.herokuapp.com/booking/10";
        //set the expected body

        //send the request and get the response
        Response response=given().when().get(url);
        response.prettyPrint();
        System.out.println("status code : "+response.getStatusCode()+"\ncontenttype : "+response.getContentType()+"\nheader : "+response.getHeader("Server")+"\nstatus line : "+
                response.getStatusLine()+"\nResponse suresi : "+response.getTime());
    }
}
