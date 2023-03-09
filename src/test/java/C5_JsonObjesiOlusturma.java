import org.json.JSONObject;
import org.junit.Test;

public class C5_JsonObjesiOlusturma {
    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
            {
            "firstname":"Jim",
            "additionalneeds":"Breakfast",
            "bookingdates":{
            "checkin":"2018-01-01",
            "checkout":"2019-01-01"
            },
            "totalprice":111,
            "depositpaid":true,
            "lastname":"Brown"
            }
     */
    @Test
    public void test(){
        JSONObject dates=new JSONObject();
        dates.put("checkin","2018-01-01");
        dates.put("checkout","2019-01-01");//INNER

        JSONObject outer=new JSONObject();
        outer.put("firstname","Jim");
        outer.put("additionalneeds","Breakfast");
        outer.put("bookingdates",dates);
        outer.put("totalprice",111);
        outer.put("depositpaid",true);
        outer.put("lastname","Brown");
        System.out.println(outer);
    }
}
