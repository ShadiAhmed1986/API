package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData02 {

    public Map<String,Object> expectedDataSetUp(){
        Map<String,Object> expected = new HashMap<>();
        expected.put("userId",9);
        expected.put("title","Tidy your room");
        expected.put("completed",false);

        return expected;
    }

    public Map<String,Object> expectedPatchDataSetUp(){
        Map<String,Object> expected = new HashMap<>();
        expected.put("title","Tidy your room");
        expected.put("userId",9);
        expected.put("completed",false);

        return expected;
    }
}
