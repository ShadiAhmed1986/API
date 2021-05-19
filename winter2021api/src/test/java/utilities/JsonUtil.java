package utilities;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    //Create 2 methods for De-Serialization and Serialization by using Object mapper
    //We will create 2 methods and we will use them again and again


    //1.Step: Create an object from Object Mapper class
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    //2.Step: Create method for De-Serialization(Json->Java)

    //Since we need flexibility in return type
    //(in Java there are many types of ob objects,that's why we use generic method)
    public static <T> T convertJsonToJava(String json, Class<T> cls){

        T javaResult = null;
        try {
            javaResult = mapper.readValue(json,cls);//use readValue() from ObjectMapper for De-Serialization
        } catch (IOException e) {
            System.out.println("Json could not be converted to JAVA" + e.getMessage());
        }

        return javaResult;
    }

    //Create a method for Serialization(Java->Json)
    public static String convertJavaToJson(Object object){

        String jsonResult = null;
        try {
            jsonResult = mapper.writeValueAsString(object);
        } catch (IOException e) {
            System.out.println("Java could not be converted to Json" + e.getMessage());
        }
        return jsonResult;
    }
}
