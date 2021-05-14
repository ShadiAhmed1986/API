package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuappTestData {

    Map<String,Object>bookingDatesMap = new HashMap<>();
    Map<String,Object> bookingDetailsMap = new HashMap<>();

    public Map<String,Object> setUpData(){
        bookingDatesMap.put("checkin","2017-11-10");
        bookingDatesMap.put("checkout","2020-08-24");
        bookingDetailsMap.put("firstname","Susan");
        bookingDetailsMap.put("lastname","Brown");
        bookingDetailsMap.put("totalprice",870);
        bookingDetailsMap.put("depositpaid",true);
        bookingDetailsMap.put("bookingdates",bookingDatesMap);
        bookingDetailsMap.put("additionalneeds", "Breakfast");

        return bookingDetailsMap;
    }

}
