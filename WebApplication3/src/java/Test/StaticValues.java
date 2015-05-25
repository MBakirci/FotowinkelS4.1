package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asror
 */
public class StaticValues {
    
    public StaticValues () { // private constructor
        myStaticcat = "Groep";
        myStaticuser = "Henk@yolo.nl";
    }
    private static String myStaticcat;
    private static String myStaticuser;
    
    public static void setMyStaticMember(String val, String kal) {
        myStaticcat = val;
        myStaticuser = kal;
    }
    
    public static String getMyStaticMember() {
        return myStaticcat;
    }

    public static String getMyStaticuser() {
    return myStaticuser;
    }

}
