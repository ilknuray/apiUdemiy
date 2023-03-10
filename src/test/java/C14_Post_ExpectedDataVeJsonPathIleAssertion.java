import org.json.JSONObject;
import org.junit.Test;

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
    public void test(){
        //set the url and request body
        String url=" https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody=new JSONObject();
        JSONObject rezTarih=new JSONObject();
        rezTarih.put("checkin","2021-06-01");
        rezTarih.put("checkout" , "2021-06-10");
        requestBody.put("firstname" , "Ahmet");
        requestBody.put("lastname" , "Bulut");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid", false);
        requestBody.put("additionalneeds", "wi-fi");
        requestBody.put("bookingsdates",rezTarih);
        //set the expected data
        JSONObject expectedData=new JSONObject();
        JSONObject obj=new JSONObject();
        obj.put("bookingid",24);
        expectedData.put("bookingid",obj);
        expectedData.put("booking",requestBody);
        System.out.println(expectedData);
    }
}
