package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuappTestData {

public String expected = "{\n" +
        "                                            \"firstname\": \"Mark\",\n" +
        "                                            \"lastname\": \"Ericsson\",\n" +
        "                                            \"totalprice\": 726,\n" +
        "                                            \"depositpaid\": true,\n" +
        "                                            \"bookingdates\": {\n" +
        "                                                \"checkin\": \"2015-08-07\",\n" +
        "                                                \"checkout\": \"2020-10-25\"\n" +
        "                                             }\n" +
        "                                          }";

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
