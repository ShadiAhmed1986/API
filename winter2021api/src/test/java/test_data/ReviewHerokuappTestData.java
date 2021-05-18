package test_data;

import java.util.HashMap;
import java.util.Map;

public class ReviewHerokuappTestData {

    public Map<String,Object> bookingDates(){
        Map<String,Object>bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2020-09-09");
        bookingdates.put("checkout", "2020-09-21");
        return bookingdates;
    }

    public Map<String,Object> expectedDataSetUp(){
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("firstname","Selim");
        expectedData.put("lastname","Ak");
        expectedData.put("totalprice", 11111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingDates());
        return expectedData;
    }
}
