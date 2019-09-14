package pct.com.practice;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String str = "67";
    	
    	boolean matches = str.matches("[0-9]+");
    	
    	//String string = str.replaceAll("[^a-zA-Z]", " ");
    	
        System.out.println(matches);
    }
}
