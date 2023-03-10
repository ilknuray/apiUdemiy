package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C4_JsonObjesiOlusturma {
    /*
    Asagidaki JSON Objesini olusturup konsolda
yazdirin.
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":1
    }

     */
    @Test
    public void Test01(){
        JSONObject obj=new JSONObject();
        obj.put("title","Ahmet");
        obj.put("body","Merhaba");
        obj.put("userId",1);
        System.out.println(obj);
    }
}
