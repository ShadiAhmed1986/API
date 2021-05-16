package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuappTestDataSunday {

    public Map<String,Object> bookingDatesSetUp(){

        Map<String,Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin","2021-05-16");
        bookingDates.put("checkin","2021-05-23");

        return bookingDates;
    }

    public Map<String,Object> expectedDataSetUp(){

        Map<String,Object> expected = new HashMap<>();
        expected.put("firstname","Selim");
        expected.put("lastname","Can");
        expected.put("totalprice",11111);
        expected.put("depositpaid",true);
        expected.put("firstname","Selim");
        expected.put("bookingdates",bookingDatesSetUp());

        return expected;
    }
}
