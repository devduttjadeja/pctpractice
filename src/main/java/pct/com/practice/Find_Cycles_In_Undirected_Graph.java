package pct.com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;


public class Find_Cycles_In_Undirected_Graph {

	private static Map<String,ArrayList<String>> map = new HashMap<>();
	private static int cycle;
	private static Stack<String> stack = new Stack<String>();
	private static String parent;
	private static List<String> visitedList = new ArrayList<>();
	private static List<String> nodeCheckedForCycle = new ArrayList<>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int numberOfVertices = Integer.parseInt(sc.nextLine());
		int numberofEdges = Integer.parseInt(sc.nextLine()); 
		
		for (int i = 0; i < numberofEdges; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			
			addEdgesToGraph(strings[0],strings[1]);
			
		}
		
		
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			
			String rootnode = entry.getKey();
			
			if(!visitedList.contains(rootnode)) {
				DFSRecursionToFindCycle(rootnode,rootnode);
			}
		}
		
		System.out.println(cycle);
		System.out.println("numberOfVertices -- "+numberOfVertices);
		
		sc.close();
		
	}

	private static void DFSRecursionToFindCycle(String node, String rootnode) {

		visitedList.add(node);
		stack.push(node);
		
		ArrayList<String> adjacentNodes = map.get(node);
		
		
		for (String adjacentNode : adjacentNodes) {
			
			if(!visitedList.contains(adjacentNode)) {
				DFSRecursionToFindCycle(adjacentNode,rootnode);
			}
			
			
		}
		

		for (String adjacentNode : adjacentNodes) {
			
			if( visitedList.contains(adjacentNode) 
					&& !adjacentNode.equals(getParent(adjacentNode,node))
					&& !nodeCheckedForCycle.contains(adjacentNode)) {
				
				cycle++;
			}
			
		}
		
		nodeCheckedForCycle.add(node);
		String lastElement = stack.pop();
		
		if(lastElement.equals(rootnode)) {
			stack.push(rootnode);
		}
	
	}


	
	
	private static String getParent(String adjacentNode, String node) {

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

		if(map.containsKey(stra)) {
			map.get(stra).add(strb);
		}else {
			ArrayList<String> al = new ArrayList<>();
			al.add(strb);
			map.put(stra, al);
		}
		
		
		if(map.containsKey(strb)) {
			map.get(strb).add(stra);
		}else {
			ArrayList<String> al = new ArrayList<>();
			al.add(stra);
			map.put(strb, al);
		}
		
	}

}
