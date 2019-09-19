package pct.com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;


/*

understanding check -- https://www.youtube.com/watch?v=CsGP_s_3GWg

input
5
5
1 2
2 3
2 4
3 4
4 5

map
{1=[2], 2=[1, 3, 4], 3=[2, 4], 4=[2, 3, 5], 5=[4]}

output
2 5

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

map
{0=[7, 8], 1=[2, 3], 2=[1, 3, 4, 8], 3=[2, 4, 1], 4=[3, 2], 5=[7, 6], 6=[7, 5], 7=[5, 6, 0], 8=[2, 0]}

output
3 8


 */
public class Find_Bridges_In_Graph {

	private static Map<String,ArrayList<String>> map = new HashMap<>();
	private static List<String> visitedList = new ArrayList<String>();
	private static int time = 0;
	private static Map<String,Integer> mapNodeTime = new LinkedHashMap<>();
	private static Stack<String> stack = new Stack<String>();
	private static int bridge = 0;
	private static int maxNodeBridge = 0;
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int numberofVertice = Integer.parseInt(sc.nextLine());
		int numberofEdges = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < numberofEdges; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			addEdgesToGraph(strings[0],strings[1],map);
		}
		
		System.out.println(map);
		
		findBridges(); 
		
		System.out.println(bridge+" "+maxNodeBridge);
		System.out.println(numberofVertice);
		
		sc.close();
	}

	
	
	
	
	private static void findBridges() {

		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			
			String node = entry.getKey();
			
			if(!visitedList.contains(node)) {
				
				findBridegsWithDFSRecursion(node);
				
			}
		}
	}


	private static void findBridegsWithDFSRecursion(String node) {
		
		visitedList.add(node);
		time++;
		stack.push(node);
		mapNodeTime.put(node, time);
		
		ArrayList<String> arrayAdjacentNode = map.get(node);
		
		for (String string : arrayAdjacentNode) {
			
			if(!visitedList.contains(string)) {
				
				findBridegsWithDFSRecursion(string);
				
			}
		}
		
		
		// 6 is backtracking to 5
		// 1. get smallest time from adjacent node except parent
		String parent = stack.pop();
		if(stack.empty()) {
			stack.push(parent);
		}
		if(parent.equals(node)) {
			parent = stack.pop();
		}
		if(stack.empty()) {
			stack.push(parent);
		}
		
		
		int smallestTime = getSmallestTimeFromAdjacentNodeExceptParent(node,parent);
		
		// 2. if smallest of parent is strictly less than smallestTime edge is a bridge
		if(mapNodeTime.get(parent) < smallestTime) {
			bridge++;
			int max = Math.max(Integer.parseInt(parent), Integer.parseInt(node));
			maxNodeBridge = Math.max(maxNodeBridge, max);
			//System.out.println(bridge);
		}
		
	}


	private static int getSmallestTimeFromAdjacentNodeExceptParent(String node, String parent) {

		ArrayList<String> adjacentNodes = map.get(node);
		int smallestTime = mapNodeTime.get(node);
		
		for (String adjacentNode : adjacentNodes) {
			
			if(!adjacentNode.equals(parent)) {
				
				if(mapNodeTime.get(adjacentNode) < smallestTime) {
					smallestTime = mapNodeTime.get(adjacentNode);
					mapNodeTime.put(node,smallestTime);
				}
				
			}
			
		}
		
		return smallestTime;
	}





	private static void addEdgesToGraph(String string0, String string1, Map<String, ArrayList<String>> map) {
		
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
