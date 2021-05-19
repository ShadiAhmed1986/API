package test_data;
import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public String expected = "{\n" +
            "  \"userId\": 10,\n" +
            " \"id\": 198,\n" +
            "  \"title\": \"quis eius est sint explicabo\",\n" +
            " \"completed\": true\n" +
            "}";

    Map<String, Object> expectedDataMap= new HashMap<>();

    public Map<String,Object> setUpData(){
        expectedDataMap.put("statusCode",200);
        expectedDataMap.put("completed",false);
        expectedDataMap.put("userId",1);
        expectedDataMap.put("title","quis ut nam facilis et officia qui");
        expectedDataMap.put("Via","1.1 vegur");
        expectedDataMap.put("Server","cloudflare");
        return expectedDataMap;
    }
}

