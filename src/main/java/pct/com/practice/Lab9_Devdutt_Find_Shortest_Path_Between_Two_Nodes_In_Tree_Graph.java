package pct.com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*

input
9
AB 5
AD 5
EA 6
BC 4
CD 2
EC 2
CF 4
DF 6
EF 1
5
AC
FB
BD
ED
AF


map
A={B=5, D=5, E=6}
B={A=5, C=4}
C={B=4, D=2, E=2, F=4} 
D={A=5, C=2, F=6} 
E={A=6, C=2, F=1} 
F={C=4, D=6, E=1}


output
7 7 6 4 7

*/
public class Lab9_Devdutt_Find_Shortest_Path_Between_Two_Nodes_In_Tree_Graph {

	private static Map<String,HashMap<String,Integer>> map = new HashMap<>();
	private static ArrayList<String> visitedList = new ArrayList<>();
	private static ArrayList<String> localPathList = new ArrayList<>();
	private static ArrayList<ArrayList<String>> listOfAllPathFromSourceToDestination = new ArrayList<>();
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		int numberOfEdges = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < numberOfEdges; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			
			String strA = Character.toString(strings[0].charAt(0));
			String strB = Character.toString(strings[0].charAt(1));
			int distance = Integer.parseInt(strings[1]);
			
			addEdgesToGraph(strA,strB,distance);
			
		}
		
		//System.out.println(map);
		
		
		int findDistance = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < findDistance; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			String source = Character.toString(strings[0].charAt(0));
			String destination = Character.toString(strings[0].charAt(1));
			
			//DFSRecursionToFindMinimumDistance(source,destination,source);
			//System.out.println(minDistance);
			
			getAllPathFromSourceToDestination(source,destination);
			int minimumDistance = getMinimumDistanceFromAllPaths(listOfAllPathFromSourceToDestination,source,destination);
			listOfAllPathFromSourceToDestination.clear();
			sb.append(minimumDistance).append(" ");
		}
		
		System.out.println(sb.toString().trim());
		
		sc.close();

	}

	private static int getMinimumDistanceFromAllPaths(ArrayList<ArrayList<String>> allpaths, String source, String destination) {
		
		int minDistance = 100000;
		
		String originalSource = source;
		
		for (ArrayList<String> path : allpaths) {
			int distance = 0;
			
			for (String node : path) {
				int dis = map.get(source).get(node);
				distance = distance + dis;
				source = node;
			}
			
			if(distance < minDistance) {
				minDistance = distance;
			}
			source = originalSource;
		}
		
		return minDistance;
	}

	private static void getAllPathFromSourceToDestination(String source, String destination) {
		visitedList.add(source);
		
		if(source.equals(destination)) {
			//System.out.println(localPathList);
			listOfAllPathFromSourceToDestination.add(new ArrayList<String>(localPathList));
			visitedList.remove(source);
			return;
		}
		
		HashMap<String, Integer> adjacentNodeMap = map.get(source);
		
		for (Map.Entry<String, Integer> entry : adjacentNodeMap.entrySet()) {
			
			if(!visitedList.contains(entry.getKey())) {
				localPathList.add(entry.getKey());
				getAllPathFromSourceToDestination(entry.getKey(), destination);
				localPathList.remove(entry.getKey());
			}
			
		}
		
		visitedList.remove(source);
		
	}

		
	private static void addEdgesToGraph(String strA, String strB, int distance) {

		if(map.containsKey(strA)) {
			map.get(strA).put(strB, distance);
		}else {
			HashMap<String,Integer> keyValueDistacneMap = new HashMap<>();
			keyValueDistacneMap.put(strB, distance);
			map.put(strA, keyValueDistacneMap);
		}
		
		if(map.containsKey(strB)) {
			map.get(strB).put(strA, distance);
		}else {
			HashMap<String,Integer> keyValueDistacneMap = new HashMap<>();
			keyValueDistacneMap.put(strA, distance);
			map.put(strB, keyValueDistacneMap);
		}
		
		
	}
}
