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

5
6
a b
a c
b c
b d
d e
e b

 */
public class Find_Cycle_In_Directed_Graph {

	private static Map<String,ArrayList<String>> map = new HashMap<>();
	private static List<String> visitedList = new ArrayList<>();
	private static Stack<String> stack = new Stack<String>();
	private static Map<String,String> childParentMap = new LinkedHashMap<>();
	private static String parent;
	private static Map<String,String> nodeFlag = new HashMap<>();
	private static boolean isCycleDetected = false;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int numberOfVertices = Integer.parseInt(sc.nextLine());
		int numberofEdges = Integer.parseInt(sc.nextLine()); 
		
		for (int i = 0; i < numberofEdges; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			
			addEdgesToGraph(strings[0],strings[1]);
			
		}
		
		
		initializeNodeFlag();
		
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			
			String rootNode = entry.getKey();
			
			if(!visitedList.contains(rootNode)) {
				
				DFSTraversalToDetectCycleInDirectedGraph(rootNode,rootNode);
				
			}
		}
		
		
		System.out.println("numberOfVertices -- "+numberOfVertices);
		
		sc.close();
		
	}


	private static void DFSTraversalToDetectCycleInDirectedGraph(String node, String rootNode) {
		
		visitedList.add(node);
		nodeFlag.put(node, "0"); // visited
		
		stack.push(node);
		parent = getParent(node);
		childParentMap.put(node, (node.equals(rootNode))? rootNode:parent );
		
		ArrayList<String> adjacentNodes =  map.get(node);
		
		if(adjacentNodes!=null) {
			for (String adjacentNode : adjacentNodes) {
				
				if(!visitedList.contains(adjacentNode)) {
					DFSTraversalToDetectCycleInDirectedGraph(adjacentNode, rootNode);
				}
			}
		}
		
		
		if(adjacentNodes!=null) {
			for (String adjacentNode : adjacentNodes) {

				if(nodeFlag.get(adjacentNode).equals("0")) {
					
					isCycleDetected = true;
					printCycle(node,adjacentNode);
				}
				
			}
		}
		
		
		String lastElement = stack.pop();
		if(lastElement.equals(rootNode)) {
			stack.push(rootNode);
		}
		
		nodeFlag.put(node, "1"); // visited and poped out
		
	}

	private static void printCycle(String node, String adjacentNode) {

		System.out.println("cycle -- "+adjacentNode);
		
		
		while(true) {
			
			String parent = childParentMap.get(node);
			
			System.out.println("cycle -- "+node);
			
			if(parent.equals(adjacentNode)) {
				break;
			}
			
			node = parent;
		}
		
	}

	private static String getParent(String node) {
		
		@SuppressWarnings("unchecked")
		Stack<String> tempStack = (Stack<String>) stack.clone();
		
		parent = stack.pop();
		if(stack.empty()) {
			stack.push(parent);
		}
		if(parent.equals(node)) {
			parent = stack.lastElement();
		}
		
		stack = tempStack;
		
		return parent;
	}

	private static void addEdgesToGraph(String stra, String strb) {

		if(map .containsKey(stra)) {
			map.get(stra).add(strb);
		}else {
			ArrayList<String> al = new ArrayList<>();
			al.add(strb);
			map.put(stra, al);
		}
		
	}
	
	
	private static void initializeNodeFlag() {
		
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {

			nodeFlag.put(entry.getKey(), "-1");
			
			for (String allnodes : entry.getValue()) {
				nodeFlag.put(allnodes, "-1");
			}
		}
	}
	
	
	
}
