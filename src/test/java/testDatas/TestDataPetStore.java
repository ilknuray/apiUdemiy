package testDatas;

import org.json.JSONObject;

public class TestDataPetStore {
    /*
    "id": 0,
  "petId": 0,
  "quantity": 0,
  "shipDate": "2023-03-23T20:28:24.296Z",
  "status": "placed",
  "complete": true
     */
    public static int basariliKodu=200;

    public static JSONObject expectedData(int id,int petId,int quantity,String shipDate,String status,boolean complete){
        JSONObject expectedData=new JSONObject();
        expectedData.put("id",id);
        expectedData.put("petId",petId);
        expectedData.put("quantity",quantity);
        expectedData.put("shipDate",shipDate);
        expectedData.put("status",status);
        expectedData.put("complete",complete);
        return expectedData;
    }
}
