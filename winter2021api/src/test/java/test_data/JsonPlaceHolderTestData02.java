package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData02 {

    public Map<String,Object> expectedDataSetUp(){
        Map<String,Object> expected = new HashMap<>();
        expected.put("userId",55);
        expected.put("title","Tidy your room");
        expected.put("completed",false);

        return expected;
    }
}
