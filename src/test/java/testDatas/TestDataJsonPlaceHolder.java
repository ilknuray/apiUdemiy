package testDatas;

import org.json.JSONObject;

public class TestDataJsonPlaceHolder {
    public static  int basariliStatusCodu=200;
    public static String contentType="application/json; charset=utf-8";
    public static String Connectionheader="keep-alive";
    public static JSONObject expectedData22(){
        JSONObject expectedData=new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear um mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expectedData;
    }
public static JSONObject responseJsonBodyOlustur(int userId,int id,String title,String body){
    JSONObject expectedData=new JSONObject();
    expectedData.put("userId",userId);
    expectedData.put("id",id);
    expectedData.put("title",title);
    expectedData.put("body",body);

return expectedData;

}
}
