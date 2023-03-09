import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonpathKullanimi {
    /*
                                        {
                                    "firstName":"Ahmet",
                                    "lastName":"Bulut",
                                    "address":{
                                    "streetAddress":"Kurtulus cad.",
                                    "city":"Ankara",
                                    "postalCode":"06100" },
                                    "age":49,
                                    "phoneNumbers":[
                                    {
                                    "number":"532-555 55 55",
                                    "type":"cep" },
                                    {
                                    "number":"0312-123 4567",
                                    "type":"ev " }
                                    ]
                                    }
     */
    @Test
    public void test(){
        JSONObject adres=new JSONObject();
        adres.put("streetAddress","Kurtulus cad.");
        adres.put("city","Ankara");
        adres.put("postalCode","06100");
        JSONArray telefonlar=new JSONArray();
        JSONObject evTel=new JSONObject();
        evTel.put("number","0312-123 4567");
        evTel.put("type","ev ");
        JSONObject cepTel=new JSONObject();
        cepTel.put("number","0312-123 4567");
        cepTel.put("type","cep");
        telefonlar.put(cepTel);
        telefonlar.put(evTel);
        JSONObject bilgiler=new JSONObject();
        bilgiler.put("phoneNumbers",telefonlar);
        bilgiler.put("address",adres);
        bilgiler.put("firstName","Ahmet");
        bilgiler.put("lastName","Bulut");
        bilgiler.put("age",49);
        System.out.println(bilgiler);
    }
}
