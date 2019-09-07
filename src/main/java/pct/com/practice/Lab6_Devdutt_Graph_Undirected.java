package pct.com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


/*

input 
9
9
1 2
2 3
3 4
2 4
1 3
2 8
5 7
6 7
5 6

output
0 3

input
9
11
1 2
2 3
3 4
2 4
1 3
2 8
5 7
6 7
5 6
0 7
0 8

output
1 1
 */
public class Lab6_Devdutt_Graph_Undirected {

	 
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		int numberOfVertice = Integer.parseInt(sc.nextLine());
		int numberOfEdges = Integer.parseInt(sc.nextLine());
		List<String> visitedList = new ArrayList<String>();
		int component=0;
		
		for(int i = 0; i < numberOfEdges; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			addEdgesToGraph(strings[0],strings[1],map);
			
		}
		
		//System.out.println(map);
		
		// find components in a graph
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			
			String key = entry.getKey();
			if(!visitedList.contains(key)) {

				DFSRecursion(key,visitedList,map);
				component++;
				
			}
			//System.out.println(visitedList);
		}
		
		
		//
		int remainingVertice = numberOfVertice - visitedList.size();
		component = component + remainingVertice;
		
		if(component > 1) {
			System.out.print("0 " + component);
		}else {
			System.out.print("1 " + component);
		}
			
		
		
		sc.close();
	}

	



	private static void DFSRecursion(String key, List<String> visitedList, Map<String, ArrayList<String>> map) {

		visitedList.add(key);
		
		ArrayList<String> list = map.get(key);
		
		for (String string : list) {
			
			if(!visitedList.contains(string)) {
				DFSRecursion(string, visitedList, map);
			}
			
			
		}
	}


	private static void addEdgesToGraph(String strA, String strB, Map<String, ArrayList<String>> map) {
		
		if(map.containsKey(strA)) {
			ArrayList<String> arrayList = map.get(strA);
			arrayList.add(strB);
			map.put(strA, arrayList);
		}else {
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add(strB);
			map.put(strA, arrayList);
		}
		
		if(map.containsKey(strB)) {
			ArrayList<String> arrayList = map.get(strB);
			arrayList.add(strA);
			map.put(strB, arrayList);
		}else {
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add(strA);
			map.put(strB, arrayList);
		}
		
	}

}
