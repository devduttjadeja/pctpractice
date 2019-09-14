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
	
	private static Map<String,ArrayList<String>> map = new HashMap<>();
	
    public static void main( String[] args )
    {
    	String str = "67";
    	
    	boolean matches = str.matches("[0-9]+");
    	
    	//String string = str.replaceAll("[^a-zA-Z]", " ");
    	
        System.out.println(matches);
        
        
        Scanner sc = new Scanner(System.in);
		
		int numberofVertice = Integer.parseInt(sc.nextLine());
		int numberofEdges = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < numberofEdges; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			addEdgesToGraph(strings[0],strings[1],map);
		}
		
		System.out.println(map);
        
		String string0 = "1";
		
        String value = map.get(string0).get(0);
		map.remove(string0);
		map.get(value).remove(string0);
		
		System.out.println(map);
        
    }
    


	private static void addEdgesToGraph(String string0, String string1, Map<String, ArrayList<String>> map) {
		
		//1=[2], 2=[1, 3, 4]
		
		if(map.containsKey(string0)) {
			map.get(string0).add(string1);
		}else {
			ArrayList<String> al = new ArrayList<String>();
			al.add(string1);
			map.put(string0, al);
		}
		
		if(map.containsKey(string1)) {
			map.get(string1).add(string0);
		}else {
			ArrayList<String> al = new ArrayList<String>();
			al.add(string0);
			map.put(string1, al);
		}
		
	}

}
