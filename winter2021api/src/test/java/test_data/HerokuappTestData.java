package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuappTestData {

public String expected = "{\n" +
        "                                            \"firstname\": \"Eric\",\n" +
        "                                            \"lastname\": \"Wilson\",\n" +
        "                                            \"totalprice\": 726,\n" +
        "                                            \"depositpaid\": true,\n" +
        "                                            \"bookingdates\": {\n" +
        "                                                \"checkin\": \"2015-08-07\",\n" +
        "                                                \"checkout\": \"2020-10-25\"\n" +
        "                                             }\n" +
        "                                          }";

    Map<String,Object>bookingDatesMap = new HashMap<>();
    Map<String,Object> bookingDetailsMap = new HashMap<>();

    public Map<String,Object> bookingDatesSetUp(){
        bookingDatesMap.put("checkin","2021-05-13");
        bookingDatesMap.put("checkout","2021-05-20");
        return bookingDatesMap;
    }

    public Map<String,Object> setUpData(){
        bookingDetailsMap.put("firstname","Susan");
        bookingDetailsMap.put("lastname","Brown");
        bookingDetailsMap.put("totalprice",870);
        bookingDetailsMap.put("depositpaid",true);
        bookingDetailsMap.put("bookingdates",bookingDatesSetUp());
        bookingDetailsMap.put("additionalneeds", "Breakfast");

        return bookingDetailsMap;
    }

}
