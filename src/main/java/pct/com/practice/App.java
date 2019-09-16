package pct.com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args )
    {
    	String str = "67";
    	boolean matches1 = str.matches("[0-9]+"); // true
    	boolean matches2 = str.matches("[0-9]"); // false
    	
    	String string = str.replaceAll("[^a-zA-Z]", " "); // string = "  ";
    	
    	String text = "12 34 56";
    	String clean = text.replaceAll("[^\\d]", "" ); // clean = "123456"';
    	
    	String complexString1 = "3ifhuq023hjk@jka$ksoap";
    	complexString1 = complexString1.replaceAll("\\d", ""); // ifhuqhjk@jka$ksoap
    	
    	String complexString2 = "3ifhuq023hjk@jka$ksoap";
    	complexString2 = complexString2.replaceAll("[^a-zA-Z0-9]", " "); // 3ifhuq023hjk jka ksoap
        
    	String complexString3 = "3ifhuq023hjk@jka$ksoap";
    	complexString3 = complexString3.replaceAll("[a-zA-Z0-9]", ""); // @$
    	
    }

}
