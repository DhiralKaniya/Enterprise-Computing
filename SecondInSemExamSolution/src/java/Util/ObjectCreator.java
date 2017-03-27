package Util;

public class ObjectCreator {
    public static Object createObject(String class_name) {
        Object obj = null;
        try {
            Class name = Class.forName( class_name );
            obj = name.newInstance();
        }
        catch(Exception e) { 
            System.err.println("Error");
        }
        return obj;        
    }
}
