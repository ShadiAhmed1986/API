package test_data;

import java.util.*;

public class OpenWeatherMapTestData {

    public Map<String, Float> coordSetUp(){
        Map<String, Float> coord = new HashMap<>();
        coord.put("lon", -0.1257f);
        coord.put("lat", 51.5085f);

        return coord;
    }

    public Map<String,Object> weatherSetUp(){
        Map<String,Object> weather = new HashMap<>();
        weather.put("id",501);
        weather.put("main","Rain");
        weather.put("description","moderate rain");
        weather.put("icon","10d");

        return weather;
    }

    List<Map> weather = Arrays.asList(weatherSetUp());

    public Map<String,Float> mainSetUp(){
        Map<String,Float> main = new HashMap<>();
        main.put("temp",286.2f);
        main.put("feels_like",285.18f);
        main.put("temp_min",288.82f);
        main.put("temp_max",288.15f);
        main.put("pressure",998f);
        main.put("humidity",76f);
        return main;
    }

    public Map<String,Float> windSetUp(){
        Map<String,Float> wind = new HashMap<>();
        wind.put("speed",5.14f);
        wind.put("deg",230f);
        return wind;
    }

    public Map<String,Float> rainSetUp(){
        Map<String,Float> rain = new HashMap<>();
        rain.put("1h",1.42f);
        return rain;
    }

    public Map<String,Float> cloudsSetUp(){
        Map<String,Float> clouds = new HashMap<>();
        clouds.put("all",75f);
        return clouds;
    }

    public Map<String,Object> sysSetUp(){
        Map<String,Object> sys = new HashMap<>();
        sys.put("type",1);
        sys.put("id",1414);
        sys.put("country","GB");
        sys.put("sunrise",1621138025);
        sys.put("sunset",1621194411);
        return sys;
    }

    public Map<String,Object> expectedDataSetUp(){
        Map<String,Object> expected = new HashMap<>();
        expected.put("coord",coordSetUp());
        expected.put("weather",weatherSetUp());
        expected.put("base","stations");
        expected.put("main",mainSetUp());
        expected.put("visibility",10000);
        expected.put("wind",windSetUp());
        expected.put("rain",rainSetUp());
        expected.put("clouds",cloudsSetUp());
        expected.put("dt",1621173209);
        expected.put("sys",sysSetUp());
        expected.put("timezone",3600);
        expected.put("id",2643743);
        expected.put("name","London");
        expected.put("cod",200);

        return expected;
    }

}
