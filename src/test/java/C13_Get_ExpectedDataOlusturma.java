import org.junit.Test;

public class C13_Get_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
                yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
                Response body :
                {
                "userId": 3,
                "id": 22,
                "title": "dolor sint quo a velit explicabo quia nam",
                "body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
                um mollitia molestiae aut atque rem suscipitnam impedit esse"
}
     */
    @Test
    public void test(){
        //set the url and request body
        String url="https://jsonplaceholder.typicode.com/posts/22";
        //=>request bodyi olusturmayacagim cunku get methodunda bir sey yollamiyorum sadece donus aliyorum
    }
}
