package pct.com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*

input
4
6
0 1
0 2
1 2
2 0
2 3
3 3
2
1 3
3 1

output 
YES NO

*/

public class Lab10_Devdutt_CheckPath_Between_Vertex {

	private static Map<String,ArrayList<String>> map = new HashMap<>();
	private static List<String> visitedList = new ArrayList<>();
	private static StringBuilder sb = new StringBuilder();
	private static boolean destinationFound = false;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < edges; i++) {
			String[] strings = sc.nextLine().split("\\s+");
			addEdgesToGraph(strings[0],strings[1]);
		}
		
		int p = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < p; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			
			findPathBetween(strings[0],strings[1]);
			
			if(destinationFound) {
				sb.append("YES").append(" ");
			}else {
				sb.append("NO").append(" ");
			}
			
			
			destinationFound = false;
			visitedList.clear();
		}
		
		System.out.println(sb.toString().trim());
		System.out.println(vertices);
		
		sc.close();
	}

	private static void findPathBetween(String source, String destination) {
		
		DFSTraversalToFindPath(source,destination);
		
	}

	private static void DFSTraversalToFindPath(String source, String destination) {

		visitedList.add(source);
		
		ArrayList<String> adjacentNodes = map.get(source);
		
		if(adjacentNodes!=null) {
			
			for (String adjacentNode : adjacentNodes) {
				
				if(adjacentNode.equals(destination)) {
					destinationFound  = true;
				}
				
				if(!visitedList.contains(adjacentNode)){
					
					DFSTraversalToFindPath(adjacentNode, destination);
					
				}
				
			}
			
			
			
		}
		
	}

	
	
	private static void addEdgesToGraph(String stra, String strb) {

		if(map.containsKey(stra)) {
			map.get(stra).add(strb);
		}else {
			ArrayList<String> al = new ArrayList<>();
			al.add(strb);
			map.put(stra, al);
		}
		
	}

}
