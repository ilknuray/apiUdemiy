package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C1_GetRequestResponseBodyYazdirma {
    @Test
    public void get01(){
        //"https://restful-booker.herokuapp.com/booking/10" url ine bir get request gonderdigimizde donen response u yazdiriniz

        //set the url
        String url="https://restful-booker.herokuapp.com/booking/10";
        //set the expected data

        //send the request and get the response
        Response response=given().when().get(url);
        response.prettyPrint();
        //Do assertion
        response.then().statusCode(200).contentType(ContentType.JSON);

    }
}
